package com.onlydan.od.restapi.admin;

import com.onlydan.od.dto.StockChangesDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/admin/stock-changes")
public interface StockChangesAdminAPI {

    // POST REQUESTS
    @PostMapping
    ResponseEntity<StockChangesDTO> createStockChanges(StockChangesDTO stockChangesDTO);

    // PUT REQUESTS
    @PutMapping("/{change-id}")
    ResponseEntity<StockChangesDTO> updateStockChangesByChangeId(@PathVariable Long changeId, StockChangesDTO stockChangesDTO);

    // GET REQUESTS
    @GetMapping
    ResponseEntity<StockChangesDTO> getStockChangesByChangeId(@RequestParam("change-id") Long changeId);

    // DELETE REQUESTS
    @DeleteMapping("/{change-id}")
    ResponseEntity<Void> deleteStockChangesByChangeId(@PathVariable Long changeId);
}
