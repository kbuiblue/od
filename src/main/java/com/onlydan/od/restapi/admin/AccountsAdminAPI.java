package com.onlydan.od.restapi.admin;

import com.onlydan.od.dto.AccountsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(value = "/api/admin/accounts")
public interface AccountsAdminAPI {

    // POST REQUESTS
    @PostMapping
    ResponseEntity<AccountsDTO> createAccount(@Valid @RequestBody AccountsDTO accountsDTO);

    // PUT REQUESTS
    @PutMapping("/{account-id}")
    ResponseEntity<AccountsDTO> updateAccountByAccountId(@PathVariable("account-id") Long accountId, @Valid @RequestBody AccountsDTO accountsDTO);

    // GET REQUESTS
    @GetMapping("/name")
    ResponseEntity<AccountsDTO> getAccountByAccountName(@RequestParam("name") @Valid String accountName);
    @GetMapping("/email")
    ResponseEntity<AccountsDTO> getAccountByEmail(@RequestParam("email") @Valid String email);

    // DELETE REQUESTS
    @DeleteMapping("/{account-id}")
    ResponseEntity<Void> deleteAccountByAccountId(@PathVariable("account-id") Long accountId);

}
