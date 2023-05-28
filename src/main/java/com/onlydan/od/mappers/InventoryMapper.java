package com.onlydan.od.mappers;

import com.onlydan.od.dto.InventoryDTO;
import com.onlydan.od.entities.Inventory;
import com.onlydan.od.entities.ProductInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InventoryMapper {

    InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);

    @Mapping(target = "inventoryId", source = "productInfo", qualifiedByName = "mapProductId")
    InventoryDTO toDTO(Inventory inventory);

    @Named("mapProductId")
    default Long mapProductId(ProductInfo productInfo) {
        return productInfo.getProductId();
    }

    List<InventoryDTO> toDTOs(List<Inventory> inventoryList);
}
