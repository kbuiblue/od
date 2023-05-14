package com.onlydan.od.resource;

import com.onlydan.od.dto.ProductInfoDTO;
import com.onlydan.od.restapi.ProductInfoAPI;
import com.onlydan.od.services.ProductInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductInfoResource implements ProductInfoAPI {
    public final ProductInfoService productInfoService;

    @Override
    public ResponseEntity<ProductInfoDTO> createProductInfo(ProductInfoDTO productInfoDTO) {
        ProductInfoDTO productInfoDto = productInfoService.createProductInfo(productInfoDTO);
        return ResponseEntity.created(URI.create("/api/product-info" + productInfoDto.getProductId())).body(productInfoDto);
    }

    @Override
    public ResponseEntity<Optional<List<ProductInfoDTO>>> getProductInfoByProductBrand(String productBrand) {
        return ResponseEntity.ok(Optional.ofNullable(productInfoService.getAllProductInfoByProductBrand(productBrand)));
    }
}
