package com.onlydan.od.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onlydan.od.enums.Gender;
import com.onlydan.od.entities.security.RoleAssignment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Accounts {
    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(columnDefinition = "boolean default true")
    private Boolean isActive;

    @UpdateTimestamp
    @Column
    private LocalDateTime creationDate;

    @Column
    private String accountName;

    @Column
    @JsonIgnore
    private String accountPassword;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoleAssignment> roles;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String phoneNumber;

    @Column
    private String address;

    @Column
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
