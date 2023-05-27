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
    public ResponseEntity<AccountsDTO> updateAccountByAccountId(Long accountId, AccountsDTO accountsDTO) {
        log.info("Account id #{} updated", accountId);
        AccountsDTO accountDto = accountsService.updateAccountByAccountId(accountId, accountsDTO);
        return ResponseEntity.ok(accountDto);
    }

    // GET
    @Override
    public ResponseEntity<AccountsDTO> getAccountByAccountName(String accountName) {
        log.info("Account name: {} fetched", accountName);
        return ResponseEntity.ok(accountsService.getAccountByAccountName(accountName));
    }

    @Override
    public ResponseEntity<AccountsDTO> getAccountByEmail(String email) {
        log.info("Account email: {} fetched", email);
        return ResponseEntity.ok(accountsService.getAccountByEmail(email));
    }

    // DELETE
    @Override
    public ResponseEntity<Void> deleteAccountByAccountId(Long accountId) {
        log.info("Account id #{} deleted", accountId);
        accountsService.deleteAccountByAccountId(accountId);
        return ResponseEntity.noContent().build();
    }

}
