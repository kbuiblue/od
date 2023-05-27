package com.onlydan.od.restapi.user;

import com.onlydan.od.dto.ProductInfoDTO;
import com.onlydan.od.services.ProductInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductInfoUserResource implements ProductInfoUserAPI {
    public final ProductInfoService productInfoService;

    //GET
    @Override
    public ResponseEntity<ProductInfoDTO> getProductInfoByProductName(String productName) {
        log.info("Product name: {} fetched", productName);
        return ResponseEntity.ok(productInfoService.getProductInfoByProductName(productName));    }

    @Override
    public ResponseEntity<List<ProductInfoDTO>> getProductInfoByProductBrand(String productBrand) {
        log.info("Product brand: {} fetched", productBrand);
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
    public ResponseEntity<ProductInfoDTO> getProductInfoByProductId(Long productId) {
        return ResponseEntity.ok(productInfoService.getProductInfoByProductId(productId));
    }
}
