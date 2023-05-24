package com.onlydan.od.security.service.dto;

import com.onlydan.od.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    public void setPasswordWithHash(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.accountPassword = passwordEncoder.encode(password);
    }
}
