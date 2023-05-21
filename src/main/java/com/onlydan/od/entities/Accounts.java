package com.onlydan.od.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Accounts {
    @Id
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
    private String accountPassword;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roleId;

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

    @Column
    private String gender;
}
