package com.onlydan.od.security.impl;

import com.onlydan.od.security.repositories.AccountsRepository;
import com.onlydan.od.security.services.UserService;
import com.onlydan.od.security.dto.AccSecurityDTO;
import com.onlydan.od.security.mappers.AccSecurityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final AccountsRepository accountsRepository;

    @Override
    public List<AccSecurityDTO> getAllAccounts() {
        return AccSecurityMapper.INSTANCE.toDTOs(accountsRepository.findAll());
    }
}
