package com.onlydan.od.restapi;

import com.onlydan.od.dto.AccountsDTO;
import com.onlydan.od.services.AccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

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
}
