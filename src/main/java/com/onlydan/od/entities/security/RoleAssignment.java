package com.onlydan.od.entities.security;

import com.onlydan.od.entities.Accounts;
import com.onlydan.od.enums.security.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentId;

    @Enumerated(EnumType.STRING)
    private Roles roleName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Accounts account;

    @CreatedDate
    @Column
    private LocalDateTime assignedDate;

    @UpdateTimestamp
    @Column
    private LocalDateTime updatedDate;
}
