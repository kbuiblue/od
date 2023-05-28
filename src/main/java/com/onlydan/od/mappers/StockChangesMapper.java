package com.onlydan.od.mappers;

import com.onlydan.od.dto.StockChangesDTO;
import com.onlydan.od.entities.StockChanges;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StockChangesMapper {
    StockChangesMapper INSTANCE = Mappers.getMapper(StockChangesMapper.class);
    StockChangesDTO toDTO(StockChanges stockChanges);
    List<StockChangesDTO> toDTOs(List<StockChanges> stockChangesList);
}
