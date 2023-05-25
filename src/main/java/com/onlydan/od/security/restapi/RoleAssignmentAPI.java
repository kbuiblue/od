package com.onlydan.od.security.restapi;

import com.onlydan.od.security.dto.RoleAssignmentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/role-assign")
public interface RoleAssignmentAPI {
    @PostMapping
    ResponseEntity<RoleAssignmentDTO> createRoleAssignment(@RequestBody RoleAssignmentDTO roleAssignmentDTO);
}
