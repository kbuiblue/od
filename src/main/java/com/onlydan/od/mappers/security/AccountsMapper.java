package com.onlydan.od.mappers.security;

import com.onlydan.od.dto.AccountsDTO;
import com.onlydan.od.entities.Accounts;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountsMapper {
    AccountsMapper INSTANCE = Mappers.getMapper(AccountsMapper.class);

    AccountsDTO toDTO(Accounts accounts);

    List<AccountsDTO> toDTOs(List<Accounts> accountsList);
}
