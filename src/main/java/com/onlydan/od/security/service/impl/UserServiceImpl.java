package com.onlydan.od.security.service.impl;

import com.onlydan.od.repositories.AccountsRepository;
import com.onlydan.od.security.service.UserService;
import com.onlydan.od.security.service.dto.AccSecurityDTO;
import com.onlydan.od.security.service.mapper.AccSecurityMapper;
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
