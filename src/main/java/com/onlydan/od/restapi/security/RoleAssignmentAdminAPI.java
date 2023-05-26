package com.onlydan.od.restapi.security;

import com.onlydan.od.dto.security.RoleAssignmentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/admin/role-assign")
public interface RoleAssignmentAdminAPI {

    // POST REQUESTS
    @PostMapping
    ResponseEntity<RoleAssignmentDTO> createRoleAssignment(@RequestBody RoleAssignmentDTO roleAssignmentDTO);

    // PUT REQUESTS
    @PutMapping("/{assignment-id}")
    ResponseEntity<RoleAssignmentDTO> updateRoleAssignmentById(@PathVariable("assignment-id") Long assignmentId,
                                                               @RequestBody RoleAssignmentDTO roleAssignmentDTO);

    // GET REQUESTS
    @GetMapping
    ResponseEntity<RoleAssignmentDTO> getRoleAssignmentById(@RequestParam("assignment-id") Long assignmentId);

    // DELETE REQUESTS
    @DeleteMapping("/{assignment-id}")
    ResponseEntity<Void> deleteRoleAssignmentById(@PathVariable("assignment-id") Long assignmentId);
}
