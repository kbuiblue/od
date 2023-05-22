package com.onlydan.od.security.service.impl;

import com.onlydan.od.entities.Accounts;
import com.onlydan.od.repositories.AccountsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AccountsRepository accountsRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
        Accounts account = accountsRepository.findByAccountName(accountName)
                .orElseThrow(() -> new UsernameNotFoundException("User with name: " + accountName + " not found"));

        return UserDetailsImpl.build(account);
    }

    @Transactional
    public UserDetails validateUser(String accountName) {
        Accounts account = accountsRepository.findByAccountName(accountName)
                .orElseThrow(() -> new UsernameNotFoundException("User with name: " + accountName + " not found"));

        return UserDetailsImpl.build(account);
    }
}
