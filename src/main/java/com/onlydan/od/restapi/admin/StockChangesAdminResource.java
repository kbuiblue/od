package com.onlydan.od.restapi.admin;

import com.onlydan.od.dto.StockChangesDTO;
import com.onlydan.od.services.StockChangesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StockChangesAdminResource implements StockChangesAdminAPI {

    public final StockChangesService stockChangesService;

    // POST
    @Override
    public ResponseEntity<StockChangesDTO> createStockChanges(StockChangesDTO stockChangesDTO) {
        log.info("Stock changes #{} added", stockChangesDTO.getStockChangeId());
        StockChangesDTO stockChangesDto = stockChangesService.createStockChanges(stockChangesDTO);
        return ResponseEntity.created(URI.create("/api/stock-changes" + stockChangesDto.getStockChangeId())).body(stockChangesDto);
    }

    // PUT
    @Override
    public ResponseEntity<StockChangesDTO> updateStockChangesByChangeId(Long changeId, StockChangesDTO stockChangesDTO) {
        log.info("Stock changes #{} updated", changeId);
        StockChangesDTO stockChangesDto = stockChangesService.updateStockChangesByChangeId(changeId, stockChangesDTO);
        return ResponseEntity.ok(stockChangesDto);
    }

    // GET
    @Override
    public ResponseEntity<StockChangesDTO> getStockChangesByChangeId(Long changeId) {
        log.info("Stock changes #{} fetched", changeId);
        return ResponseEntity.ok(stockChangesService.getStockChangesByChangeId(changeId));
    }

    // DELETE
    @Override
    public ResponseEntity<Void> deleteStockChangesByChangeId(Long changeId) {
        log.info("Stock changes #{} deleted", changeId);
        stockChangesService.deleteStockChangesByChangeId(changeId);
        return ResponseEntity.noContent().build();
    }
}
