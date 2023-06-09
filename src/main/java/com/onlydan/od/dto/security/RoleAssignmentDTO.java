package com.onlydan.od.dto.security;

import com.onlydan.od.enums.security.Roles;
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

    private Long accountId;

    private LocalDateTime assignedDate;

    private LocalDateTime updatedDate;

}
