package com.onlydan.od.services;

import com.onlydan.od.dto.AccountsDTO;
import com.onlydan.od.entities.Accounts;
import com.onlydan.od.exceptions.AllExceptions;
import com.onlydan.od.mappers.AccountsMapper;
import com.onlydan.od.repositories.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountsService {
    private final AccountsRepository accountsRepository;
    private final AccountsMapper accountsMapper;

    //GET REQUESTS
    public AccountsDTO getAccountByAccountName(String accountName) {
        Accounts accounts = accountsRepository
                .getAccountByAccountName(accountName).orElseThrow(AllExceptions::AccountNameNotFound);

        return accountsMapper.INSTANCE.toDTO(accounts);
    }

    public AccountsDTO getAccountByEmail(String email) {
        Accounts accounts = accountsRepository
                .getAccountByEmail(email).orElseThrow(AllExceptions::AccountNameNotFound);

        return accountsMapper.INSTANCE.toDTO(accounts);
    }

}
