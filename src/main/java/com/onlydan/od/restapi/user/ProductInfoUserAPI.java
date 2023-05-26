package com.onlydan.od.restapi.user;

import com.onlydan.od.dto.ProductInfoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/user/product-info")
public interface ProductInfoUserAPI {
    //GET REQUESTS
    @GetMapping
    ResponseEntity<ProductInfoDTO> getProductInfoByProductName(@RequestParam("product-name") String productName);

    @GetMapping("/brands")
    ResponseEntity<List<ProductInfoDTO>> getProductInfoByProductBrand(@RequestParam("brand") String productBrand);

    @GetMapping("/conditions")
    ResponseEntity<List<ProductInfoDTO>> getProductInfoByProductCondition(@RequestParam("condition") String productCondition);

    @GetMapping("/types")
    ResponseEntity<List<ProductInfoDTO>> getProductInfoByProductType(@RequestParam("type") String productType);

    @GetMapping("/countries")
    ResponseEntity<List<ProductInfoDTO>> getProductInfoByCountryId(@RequestParam("country-id") String countryId);

    @GetMapping("/{productId}")
    ResponseEntity<ProductInfoDTO> getProductInfoById(@PathVariable("product-id") Long productId);
}
