package com.onlydan.od.repositories.security;

import com.onlydan.od.entities.security.RoleAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleAssignmentRepository extends JpaRepository<RoleAssignment, Long> {

}
