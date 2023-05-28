package com.onlydan.od.services;

import com.onlydan.od.dto.StockChangesDTO;
import com.onlydan.od.entities.StockChanges;
import com.onlydan.od.exceptions.AllExceptions;
import com.onlydan.od.mappers.StockChangesMapper;
import com.onlydan.od.repositories.StockChangesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class StockChangesService {

    private final StockChangesRepository stockChangesRepository;

    private final StockChangesMapper stockChangesMapper;

    // POST REQUESTS
    public StockChangesDTO createStockChanges(StockChangesDTO stockChangesDTO) {

        StockChanges stockChanges = StockChanges.builder()
                .changeAmount(stockChangesDTO.getChangeAmount())
                .changeDate(stockChangesDTO.getChangeDate())
                .changeType(stockChangesDTO.getChangeType())
                .remainingAmount(stockChangesDTO.getRemainingAmount())
                .build();

        StockChanges savedStockChanges = stockChangesRepository.save(stockChanges);

        return stockChangesMapper.INSTANCE.toDTO(savedStockChanges);
    }

    // PUT REQUESTS
    public StockChangesDTO updateStockChangesByChangeId(Long changeId, StockChangesDTO stockChangesDTO) {
        StockChanges stockChanges = stockChangesRepository.findById(changeId)
                .orElseThrow(AllExceptions::StockChangeNotFound);

        stockChanges.setChangeAmount(stockChangesDTO.getChangeAmount());
        stockChanges.setChangeDate(stockChangesDTO.getChangeDate());
        stockChanges.setChangeType(stockChangesDTO.getChangeType());
        stockChanges.setRemainingAmount(stockChangesDTO.getRemainingAmount());

        StockChanges savedStockChanges = stockChangesRepository.save(stockChanges);

        return stockChangesMapper.INSTANCE.toDTO(savedStockChanges);
    }

    // GET REQUESTS
    public StockChangesDTO getStockChangesByChangeId(Long changeId) {
        StockChanges stockChanges = stockChangesRepository.findById(changeId)
                .orElseThrow(AllExceptions::StockChangeNotFound);

        return stockChangesMapper.INSTANCE.toDTO(stockChanges);
    }

    // DELETE REQUESTS
    public void deleteStockChangesByChangeId(Long changeId) {
        stockChangesRepository.deleteById(changeId);
    }
}
