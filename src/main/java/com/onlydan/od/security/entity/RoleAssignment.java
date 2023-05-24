package com.onlydan.od.security.entity;

import com.onlydan.od.entities.Accounts;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class RoleAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentId;

    @Enumerated(EnumType.STRING)
    private Roles role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Accounts accounts;

    @CreatedDate
    @Column
    private LocalDateTime assignedDate;

    @UpdateTimestamp
    @Column
    private LocalDateTime updatedDate;
}
