package com.onlydan.od.security.restapi;

import com.onlydan.od.security.dto.RoleAssignmentDTO;
import com.onlydan.od.security.services.RoleAssignmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@Slf4j
@RequiredArgsConstructor
public class RoleAssignmentResource implements RoleAssignmentAPI {

    private final RoleAssignmentService roleAssignmentService;
    @Override
    public ResponseEntity<RoleAssignmentDTO> createRoleAssignment(RoleAssignmentDTO roleAssignmentDTO) {
        log.info("Account id #{} added", roleAssignmentDTO.getAssignmentId());
        RoleAssignmentDTO roleAssignmentDto = roleAssignmentService.createRoleAssignment(roleAssignmentDTO);
        return ResponseEntity.created(URI.create("/api/role-assign" + roleAssignmentDto.getAssignmentId())).body(roleAssignmentDto);
    }
}
