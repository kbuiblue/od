package com.onlydan.od.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onlydan.od.enums.Gender;
import com.onlydan.od.security.entity.RoleAssignment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    @UpdateTimestamp
    @Column
    private LocalDateTime creationDate;

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
    public Accounts (String accountName, String accountPassword) {
        this.accountName = accountName;
        this.accountPassword = accountPassword;
        this.isActive = true;
    }
}
