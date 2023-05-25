package com.onlydan.od.restapi;

import com.onlydan.od.dto.AccountsDTO;
import com.onlydan.od.security.services.AccountsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AccountsResource implements AccountsAPI {

    public final AccountsService accountsService;
    @Override
    public ResponseEntity<AccountsDTO> getAccountByAccountName(String accountName) {
        return ResponseEntity.ok(accountsService.getAccountByAccountName(accountName));
    }

    @Override
    public ResponseEntity<AccountsDTO> getAccountByEmail(String email) {
        return ResponseEntity.ok(accountsService.getAccountByEmail(email));
    }

    @Override
    public ResponseEntity<AccountsDTO> createAccount(AccountsDTO accountsDTO) {
        log.info("Account id #{} added", accountsDTO.getAccountId());
        AccountsDTO accountsDto = accountsService.createAccount(accountsDTO);
        return ResponseEntity.created(URI.create("/api/accounts" + accountsDto.getAccountId())).body(accountsDto);
    }
}
