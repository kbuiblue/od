package com.onlydan.od.services.security;

import com.onlydan.od.entities.Accounts;
import com.onlydan.od.exceptions.AllExceptions;
import com.onlydan.od.mappers.security.RoleAssignmentMapper;
import com.onlydan.od.repositories.security.AccountsRepository;
import com.onlydan.od.repositories.security.RoleAssignmentRepository;
import com.onlydan.od.entities.security.RoleAssignment;
import com.onlydan.od.dto.security.RoleAssignmentDTO;
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
        Accounts accounts = accountsRepository.findById(roleAssignmentDTO.getAccountId())
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

    //PUT REQUEST
    public RoleAssignmentDTO updateRoleAssignmentById(Long assignmentId, RoleAssignmentDTO roleAssignmentDTO) {
        RoleAssignment roleAssignment = roleAssignmentRepository.findById(assignmentId)
                .orElseThrow(AllExceptions::ProductInfoNotFound);

        Accounts accounts = accountsRepository.findById(roleAssignmentDTO.getAccountId())
                .orElseThrow(AllExceptions::AccountNotFound);

        roleAssignment.setRole(roleAssignmentDTO.getRole());
        roleAssignment.setAccount(accounts);
        roleAssignment.setAssignedDate(roleAssignmentDTO.getAssignedDate());
        roleAssignment.setUpdatedDate(roleAssignmentDTO.getUpdatedDate());

        RoleAssignment savedRoleAssignment = roleAssignmentRepository.save(roleAssignment);

        return roleAssignmentMapper.INSTANCE.toDTO(savedRoleAssignment);
    }

    // GET REQUEST
    public RoleAssignmentDTO getRoleAssignmentById(Long assignmentId) {
        RoleAssignment roleAssignment = roleAssignmentRepository.findById(assignmentId)
                .orElseThrow(AllExceptions::RoleAssignmentNotFound);

        return roleAssignmentMapper.INSTANCE.toDTO(roleAssignment);
    }

    //DELETE REQUEST
    public void deleteRoleAssignmentById(Long assignmentId) {
        roleAssignmentRepository.deleteById(assignmentId);
    }
}
