package com.onlydan.od.security.dto;

import com.onlydan.od.security.entity.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleAssignmentDTO {

    private Long assignmentId;

    private Roles role;

    private Long accountsId;

    private LocalDateTime assignedDate;

    private LocalDateTime updatedDate;

}
