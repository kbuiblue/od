package com.onlydan.od.restapi.admin;

import com.onlydan.od.dto.InventoryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(value = "/api/admin/inventory")
public interface InventoryAdminAPI {

    //POST REQUESTS
    @PostMapping
    ResponseEntity<InventoryDTO> createInventory(@Valid @RequestBody InventoryDTO inventoryDTO);

    //PUT REQUESTS
    @PutMapping("/{inventory-id}")
    ResponseEntity<InventoryDTO> updateInventoryByInventoryId(@PathVariable("inventory-id") Long inventoryId, @Valid @RequestBody InventoryDTO inventoryDTO);

    //GET REQUESTS
    @GetMapping
    ResponseEntity<InventoryDTO> getInventoryByInventoryId(@RequestParam("inventory-id") Long inventoryId);

    //DELETE REQUESTS
    @DeleteMapping("/{inventory-id}")
    ResponseEntity<Void> deleteInventoryByInventoryId(@PathVariable("inventory-id") Long inventoryId);
}
