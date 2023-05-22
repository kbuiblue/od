package com.onlydan.od.security.service;


import com.onlydan.od.security.service.dto.AccSecurityDTO;

import java.util.List;

public interface UserService {
    List<AccSecurityDTO> getAllAccounts();
}
