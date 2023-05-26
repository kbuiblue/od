package com.onlydan.od.mappers.security;

import com.onlydan.od.entities.Accounts;
import com.onlydan.od.entities.security.RoleAssignment;
import com.onlydan.od.dto.security.RoleAssignmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleAssignmentMapper {
    RoleAssignmentMapper INSTANCE = Mappers.getMapper(RoleAssignmentMapper.class);

    @Mapping(target = "assignmentId", source = "account", qualifiedByName = "mapAccountId")
    RoleAssignmentDTO toDTO(RoleAssignment roleAssignment);

    @Named("mapAccountId")
    default Long mapAccountId(Accounts accounts) {
        return accounts.getAccountId();
    }

    List<RoleAssignmentDTO> toDTOs(List<RoleAssignment> roleAssignments);
}
