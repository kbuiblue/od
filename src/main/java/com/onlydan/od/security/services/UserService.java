package com.onlydan.od.security.services;


import com.onlydan.od.security.dto.AccSecurityDTO;

import java.util.List;

public interface UserService {
    List<AccSecurityDTO> getAllAccounts();
}
