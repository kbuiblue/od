package com.onlydan.od.restapi.admin;

import com.onlydan.od.dto.InventoryDTO;
import com.onlydan.od.services.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Slf4j
@RestController
@RequiredArgsConstructor
public class InventoryAdminResource implements InventoryAdminAPI {
    public final InventoryService inventoryService;
    @Override
    public ResponseEntity<InventoryDTO> createInventory(InventoryDTO inventoryDTO) {
        log.info("Inventory id #{} added", inventoryDTO.getInventoryId());
        InventoryDTO inventoryDto = inventoryService.createInventory(inventoryDTO);
        return ResponseEntity.created(URI.create("/api/inventory" + inventoryDto.getInventoryId())).body(inventoryDto);
    }

    @Override
    public ResponseEntity<InventoryDTO> updateInventoryByInventoryId(Long inventoryId, InventoryDTO inventoryDTO) {
        log.info("Inventory id #{} updated", inventoryId);
        InventoryDTO inventoryDto = inventoryService.updateInventoryByInventoryId(inventoryId, inventoryDTO);
        return ResponseEntity.ok(inventoryDto);
    }

    @Override
    public ResponseEntity<InventoryDTO> getInventoryByInventoryId(Long inventoryId) {
        log.info("Inventory id #{} fetched", inventoryId);
        return ResponseEntity.ok(inventoryService.getInventoryByInventoryId(inventoryId));
    }

    @Override
    public ResponseEntity<Void> deleteInventoryByInventoryId(Long inventoryId) {
        log.info("Inventory id #{} deleted", inventoryId);
        inventoryService.deleteInventoryByInventoryId(inventoryId);
        return ResponseEntity.noContent().build();
    }
}
