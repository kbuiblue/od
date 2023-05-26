package com.onlydan.od.restapi.admin;

import com.onlydan.od.dto.AccountsDTO;
import com.onlydan.od.services.security.AccountsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AccountsAdminResource implements AccountsAdminAPI {

    public final AccountsService accountsService;

    // POST
    @Override
    public ResponseEntity<AccountsDTO> createAccount(AccountsDTO accountsDTO) {
        log.info("Account id #{} added", accountsDTO.getAccountId());
        AccountsDTO accountsDto = accountsService.createAccount(accountsDTO);
        return ResponseEntity.created(URI.create("/api/accounts" + accountsDto.getAccountId())).body(accountsDto);
    }

    // PUT
    @Override
    public ResponseEntity<AccountsDTO> updateAccountById(Long accountId, AccountsDTO accountsDTO) {
        log.info("Account id #{} updated", accountId);
        AccountsDTO accountDto = accountsService.updateAccountById(accountId, accountsDTO);
        return ResponseEntity.ok(accountDto);
    }

    // GET
    @Override
    public ResponseEntity<AccountsDTO> getAccountByAccountName(String accountName) {
        return ResponseEntity.ok(accountsService.getAccountByAccountName(accountName));
    }

    @Override
    public ResponseEntity<AccountsDTO> getAccountByEmail(String email) {
        return ResponseEntity.ok(accountsService.getAccountByEmail(email));
    }

    // DELETE
    @Override
    public ResponseEntity<Void> deleteAccountById(Long accountId) {
        log.info("Account id #{} deleted", accountId);
        accountsService.deleteAccountById(accountId);
        return ResponseEntity.noContent().build();
    }

}
