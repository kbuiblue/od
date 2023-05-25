package com.onlydan.od.security.dto;

import com.onlydan.od.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountsSignUpDTO {
    private String accountName;

    private String accountPassword;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private LocalDateTime creationDate;

    private String address;

    private String email;

    private Gender gender;

}
