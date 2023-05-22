package com.onlydan.od.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onlydan.od.enums.Gender;
import com.onlydan.od.security.entity.RoleAssignment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Accounts {
    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column
    private Boolean isActive;

    @CreatedDate
    @Column
    private LocalDate creationDate;

    @Column
    private String accountName;

    @Column
    @JsonIgnore
    private String accountPassword;

    @OneToMany(mappedBy = "accounts", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<RoleAssignment> roles;

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
