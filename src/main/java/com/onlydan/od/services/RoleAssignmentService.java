package com.onlydan.od.services;

import com.onlydan.od.entities.Accounts;
import com.onlydan.od.exceptions.AllExceptions;
import com.onlydan.od.repositories.AccountsRepository;
import com.onlydan.od.security.repositories.RoleAssignmentRepository;
import com.onlydan.od.security.entity.RoleAssignment;
import com.onlydan.od.security.service.dto.RoleAssignmentDTO;
import com.onlydan.od.security.service.mapper.RoleAssignmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleAssignmentService {

    private final RoleAssignmentRepository roleAssignmentRepository;

    private final RoleAssignmentMapper roleAssignmentMapper;

    private final AccountsRepository accountsRepository;

    //POST REQUEST
    public RoleAssignmentDTO createRoleAssignment(RoleAssignmentDTO roleAssignmentDTO) {
        Accounts accounts = accountsRepository.findById(roleAssignmentDTO.getAccountsId())
                .orElseThrow(AllExceptions::AccountNotFound);

        RoleAssignment roleAssignment = RoleAssignment.builder()
                .role(roleAssignmentDTO.getRole())
                .account(accounts)
                .assignedDate(roleAssignmentDTO.getAssignedDate())
                .updatedDate(roleAssignmentDTO.getUpdatedDate())
                .build();

        RoleAssignment savedRoleAssignment = roleAssignmentRepository.save(roleAssignment);

        return roleAssignmentMapper.INSTANCE.toDTO(savedRoleAssignment);
    }
}
