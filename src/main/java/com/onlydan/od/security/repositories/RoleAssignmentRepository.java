package com.onlydan.od.security.repositories;

import com.onlydan.od.security.entities.RoleAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleAssignmentRepository extends JpaRepository<RoleAssignment, Long> {

}
