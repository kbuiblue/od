package com.onlydan.od.restapi.admin;

import com.onlydan.od.dto.AccountsDTO;
import com.onlydan.od.dto.custom.TopCustomersDTO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

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

    @GetMapping("/top-customers")
    ResponseEntity<List<TopCustomersDTO>> getTopCustomersFromDateRange(@RequestParam("topN") Integer topN,
                                                                       @RequestParam("startDate")
                                                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                                       @RequestParam("endDate")
                                                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);

    // DELETE REQUESTS
    @DeleteMapping("/{account-id}")
    ResponseEntity<Void> deleteAccountByAccountId(@PathVariable("account-id") Long accountId);

}
