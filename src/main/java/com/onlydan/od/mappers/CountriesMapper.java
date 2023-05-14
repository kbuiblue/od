package com.onlydan.od.mappers;

import com.onlydan.od.dto.CountriesDTO;
import com.onlydan.od.entities.Countries;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CountriesMapper {
    CountriesMapper INSTANCE = Mappers.getMapper(CountriesMapper.class);

    CountriesDTO toDTO(Countries countries);

    List<CountriesDTO> toDTOs(List<Countries> countriesList);
}
