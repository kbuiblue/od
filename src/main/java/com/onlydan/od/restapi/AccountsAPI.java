package com.onlydan.od.restapi;

import com.onlydan.od.dto.AccountsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(value = "/api/accounts")
public interface AccountsAPI {
    @GetMapping("/name")
    ResponseEntity<AccountsDTO> getAccountByAccountName(@RequestParam("name") @Valid String accountName);

    @GetMapping("/email")
    ResponseEntity<AccountsDTO> getAccountByEmail(@RequestParam("email") @Valid String email);

    @PostMapping
    ResponseEntity<AccountsDTO> createAccount(@Valid @RequestBody AccountsDTO accountsDTO);
}
