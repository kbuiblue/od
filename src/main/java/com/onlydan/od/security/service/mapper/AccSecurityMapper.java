package com.onlydan.od.security.service.mapper;

import com.onlydan.od.entities.Accounts;
import com.onlydan.od.security.service.dto.AccSecurityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccSecurityMapper {
    AccSecurityMapper INSTANCE = Mappers.getMapper(AccSecurityMapper.class);

    AccSecurityDTO toDTO(Accounts accounts);

    List<AccSecurityDTO> toDTOs(List<Accounts> accountsList);
}
