package com.onlydan.od.restapi.admin;

import com.onlydan.od.dto.ProductInfoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RequestMapping(value = "/api/admin/product-info")
public interface ProductInfoAdminAPI {
    //POST REQUESTS
    @PostMapping
    ResponseEntity<ProductInfoDTO> createProductInfo(@RequestBody ProductInfoDTO productInfoDTO);

    //PUT REQUESTS
    @PutMapping("/{product-id}")
    ResponseEntity<ProductInfoDTO> updateProductInfoById(@PathVariable("product-id") Long productId, @RequestBody ProductInfoDTO productInfoDTO);

    //DELETE REQUESTS
    @DeleteMapping("/{product-id}")
    ResponseEntity<Void> deleteProductInfoById(@PathVariable("product-id") Long productId);
}
