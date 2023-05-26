package com.onlydan.od.restapi.security;

import com.onlydan.od.dto.security.RoleAssignmentDTO;
import com.onlydan.od.services.security.RoleAssignmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@Slf4j
@RequiredArgsConstructor
public class RoleAssignmentAdminResource implements RoleAssignmentAdminAPI {

    private final RoleAssignmentService roleAssignmentService;

    // POST
    @Override
    public ResponseEntity<RoleAssignmentDTO> createRoleAssignment(RoleAssignmentDTO roleAssignmentDTO) {
        log.info("Account id #{} added", roleAssignmentDTO.getAssignmentId());
        RoleAssignmentDTO roleAssignmentDto = roleAssignmentService.createRoleAssignment(roleAssignmentDTO);
        return ResponseEntity.created(URI.create("/api/role-assign" + roleAssignmentDto.getAssignmentId())).body(roleAssignmentDto);
    }

    // PUT
    @Override
    public ResponseEntity<RoleAssignmentDTO> updateRoleAssignmentById(Long assignmentId, RoleAssignmentDTO roleAssignmentDTO) {
        log.info("Account id #{} updated", assignmentId);
        RoleAssignmentDTO roleAssignmentDto = roleAssignmentService.updateRoleAssignmentById(assignmentId, roleAssignmentDTO);
        return ResponseEntity.ok(roleAssignmentDto);
    }

    // GET
    @Override
    public ResponseEntity<RoleAssignmentDTO> getRoleAssignmentById(Long assignmentId) {
        return ResponseEntity.ok(roleAssignmentService.getRoleAssignmentById(assignmentId));
    }

    // DELETE
    @Override
    public ResponseEntity<Void> deleteRoleAssignmentById(Long assignmentId) {
        log.info("Account id #{} deleted", assignmentId);
        roleAssignmentService.deleteRoleAssignmentById(assignmentId);
        return ResponseEntity.noContent().build();
    }
}
