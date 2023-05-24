package com.onlydan.od.dto;

import com.onlydan.od.enums.Gender;
import com.onlydan.od.security.entity.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountsDTO {

    private Long accountId;

    private String accountName;
     
    private String accountPassword;

    private Roles role;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private LocalDateTime creationDate;

    private String address;

    private String email;

    private Gender gender;

    private Boolean isActive;
}
