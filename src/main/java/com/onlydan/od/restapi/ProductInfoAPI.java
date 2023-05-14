package com.onlydan.od.restapi;

import com.onlydan.od.dto.ProductInfoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/product-info")
public interface ProductInfoAPI {

    //POST REQUESTS
    @PostMapping
    ResponseEntity<ProductInfoDTO> createProductInfo(@RequestBody ProductInfoDTO productInfoDTO);

    //PUT REQUESTS
    @PutMapping("/{product-id}")
    ResponseEntity<ProductInfoDTO> updateProductInfo(@PathVariable("product-id") Long productId, @RequestBody ProductInfoDTO productInfoDTO);

    //DELETE REQUESTS
    @DeleteMapping("/{product-id}")
    ResponseEntity<Void> deleteProductInfoById(@PathVariable("product-id") Long productId);

    //GET REQUESTS
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
