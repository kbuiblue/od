package com.onlydan.od.services;

import com.onlydan.od.dto.InventoryDTO;
import com.onlydan.od.entities.Inventory;
import com.onlydan.od.entities.ProductInfo;
import com.onlydan.od.entities.StockChanges;
import com.onlydan.od.exceptions.AllExceptions;
import com.onlydan.od.mappers.InventoryMapper;
import com.onlydan.od.repositories.InventoryRepository;
import com.onlydan.od.repositories.ProductInfoRepository;
import com.onlydan.od.repositories.StockChangesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;
    private final StockChangesRepository stockChangesRepository;
    private final ProductInfoRepository productInfoRepository;

    // POST REQUESTS
    public InventoryDTO createInventory(InventoryDTO inventoryDTO) {
        StockChanges stockChange = stockChangesRepository.findById(inventoryDTO.getStockChangeId())
                .orElseThrow(AllExceptions::StockChangeNotFound);
        ProductInfo productInfo = productInfoRepository.findById(inventoryDTO.getProductId())
                .orElseThrow(AllExceptions::ProductInfoNotFound);

        Inventory inventory = Inventory.builder()
                .inventoryStatus(inventoryDTO.getInventoryStatus())
                .shippingStatus(inventoryDTO.getShippingStatus())
                .productInfo(productInfo)
                .stockChange(stockChange)
                .build();

        Inventory savedInventory = inventoryRepository.save(inventory);

        return inventoryMapper.INSTANCE.toDTO(savedInventory);
    }

    // PUT REQUESTS
    public InventoryDTO updateInventoryByInventoryId(Long inventoryId, InventoryDTO inventoryDTO) {
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(AllExceptions::InventoryNotFound);
        StockChanges stockChange = stockChangesRepository.findById(inventoryDTO.getStockChangeId())
                .orElseThrow(AllExceptions::StockChangeNotFound);
        ProductInfo productInfo = productInfoRepository.findById(inventoryDTO.getProductId())
                .orElseThrow(AllExceptions::ProductInfoNotFound);

        inventory.setInventoryStatus(inventoryDTO.getInventoryStatus());
        inventory.setShippingStatus(inventoryDTO.getShippingStatus());
        inventory.setProductInfo(productInfo);
        inventory.setStockChange(stockChange);

        Inventory savedInventory = inventoryRepository.save(inventory);

        return inventoryMapper.INSTANCE.toDTO(savedInventory);
    }

    //GET REQUESTS
    public InventoryDTO getInventoryByInventoryId(Long inventoryId) {
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(AllExceptions::InventoryNotFound);

        return inventoryMapper.INSTANCE.toDTO(inventory);
    }

    //DELETE REQUESTS
    public void deleteInventoryByInventoryId(Long inventoryId) {
        inventoryRepository.deleteById(inventoryId);
    }
}
