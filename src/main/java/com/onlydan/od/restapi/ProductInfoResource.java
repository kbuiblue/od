package com.onlydan.od.restapi;

import com.onlydan.od.dto.ProductInfoDTO;
import com.onlydan.od.services.ProductInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductInfoResource implements ProductInfoAPI {
    public final ProductInfoService productInfoService;

    // POST
    @Override
    public ResponseEntity<ProductInfoDTO> createProductInfo(ProductInfoDTO productInfoDTO) {
        log.info("Product id #{} added", productInfoDTO.getProductId());
        ProductInfoDTO productInfoDto = productInfoService.createProductInfo(productInfoDTO);
        return ResponseEntity.created(URI.create("/api/product-info" + productInfoDto.getProductId())).body(productInfoDto);
    }
    // PUT
    @Override
    public ResponseEntity<ProductInfoDTO> updateProductInfo(Long productId, ProductInfoDTO productInfoDTO) {
        log.info("Product id #{} updated", productId);
        ProductInfoDTO productInfoDto = productInfoService.updateProductInfo(productId, productInfoDTO);
        return ResponseEntity.ok(productInfoDto);
    }

    //DELETE

    @Override
    public ResponseEntity<Void> deleteProductInfoById(Long productId) {
        log.info("Product id #{} deleted", productId);
        productInfoService.deleteProductInfoById(productId);
        return ResponseEntity.noContent().build();
    }

    //GET
    @Override
    public ResponseEntity<List<ProductInfoDTO>> getProductInfoByProductBrand(String productBrand) {
        log.info("Get product info by product brand {} ", productBrand);
        return ResponseEntity.ok(productInfoService.getAllProductInfoByProductBrand(productBrand));
    }

    @Override
    public ResponseEntity<List<ProductInfoDTO>> getProductInfoByProductCondition(String productCondition) {
        return ResponseEntity.ok(productInfoService.getAllProductInfoByProductCondition(productCondition));
    }

    @Override
    public ResponseEntity<List<ProductInfoDTO>> getProductInfoByProductType(String productType) {
        return ResponseEntity.ok(productInfoService.getAllProductInfoByProductType(productType));
    }

    @Override
    public ResponseEntity<List<ProductInfoDTO>> getProductInfoByCountryId(String countryId) {
        return ResponseEntity.ok(productInfoService.getAllProductInfoByCountryId(countryId));
    }

    @Override
    public ResponseEntity<ProductInfoDTO> getProductInfoById(Long productId) {
        return ResponseEntity.ok(productInfoService.getProductInfoById(productId));
    }
}
