package com.onlydan.od.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountsDTO {

    private String accountName;
     
    private String accountPassword;

    private RolesDTO roleId;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String address;

    private String email;

    private String gender;
}
