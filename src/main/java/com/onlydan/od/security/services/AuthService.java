package com.onlydan.od.security.services;

import com.onlydan.od.entities.Accounts;
import com.onlydan.od.exceptions.AllExceptions;
import com.onlydan.od.security.config.WebSecurityConfig;
import com.onlydan.od.security.jwt.JwtRequest;
import com.onlydan.od.security.repositories.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {

    private final AccountsRepository accountsRepository;

    private final AccountsService accountsService;

    private final WebSecurityConfig webSecurityConfig;

    public Accounts createAccount(JwtRequest signupRequest) {
        // Check if the user already exists
        if (accountsService.checkIfAccountExists(signupRequest.getAccountName()))
            throw AllExceptions.AccountNameAlreadyExists();

        String encodedPassword = webSecurityConfig.passwordEncoder().encode(signupRequest.getPassword());

        Accounts newAccount = Accounts.builder()
                .accountName(signupRequest.getAccountName())
                .accountName(signupRequest.getAccountName())
                .isActive(true)
                .accountPassword(encodedPassword)
                .creationDate(LocalDateTime.now())
                .build();

        accountsRepository.save(newAccount);

        return newAccount;
    }
}
