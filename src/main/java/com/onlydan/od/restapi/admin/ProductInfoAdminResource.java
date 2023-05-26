package com.onlydan.od.restapi.admin;

import com.onlydan.od.dto.ProductInfoDTO;
import com.onlydan.od.services.ProductInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductInfoAdminResource implements ProductInfoAdminAPI {

    private final ProductInfoService productInfoService;

    // POST
    @Override
    public ResponseEntity<ProductInfoDTO> createProductInfo(ProductInfoDTO productInfoDTO) {
        log.info("Product: " + productInfoDTO.getProductName() + " added");
        ProductInfoDTO productInfoDto = productInfoService.createProductInfo(productInfoDTO);
        return ResponseEntity.created(URI.create("/api/product-info" + productInfoDto.getProductId())).body(productInfoDto);
    }
    // PUT
    @Override
    public ResponseEntity<ProductInfoDTO> updateProductInfoById(Long productId, ProductInfoDTO productInfoDTO) {
        log.info("Product id #{} updated", productId);
        ProductInfoDTO productInfoDto = productInfoService.updateProductInfoById(productId, productInfoDTO);
        return ResponseEntity.ok(productInfoDto);
    }

    //ALL GET REQUESTS ARE SHARED WITH USER

    //DELETE
    @Override
    public ResponseEntity<Void> deleteProductInfoById(Long productId) {
        log.info("Product id #{} deleted", productId);
        productInfoService.deleteProductInfoById(productId);
        return ResponseEntity.noContent().build();
    }
}
