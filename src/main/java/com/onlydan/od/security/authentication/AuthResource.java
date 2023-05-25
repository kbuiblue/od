package com.onlydan.od.security.authentication;

import com.onlydan.od.dto.AccountsDTO;
import com.onlydan.od.entities.Accounts;
import com.onlydan.od.exceptions.AllExceptions;
import com.onlydan.od.mappers.AccountsMapper;
import com.onlydan.od.security.config.WebSecurityConfig;
import com.onlydan.od.security.entities.Roles;
import com.onlydan.od.security.dto.RoleAssignmentDTO;
import com.onlydan.od.security.impl.UserDetailsImpl;
import com.onlydan.od.security.jwt.JwtRequest;
import com.onlydan.od.security.jwt.JwtResponse;
import com.onlydan.od.security.jwt.JwtUtils;
import com.onlydan.od.security.services.AccountsService;
import com.onlydan.od.security.services.RoleAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AuthResource implements AuthAPI {

    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    private final WebSecurityConfig webSecurityConfig;

    private final AccountsService accountsService;

    private final UserDetailsService userDetailsService;

    private final AccountsMapper accountsMapper;

    private final RoleAssignmentService roleAssignmentService;

    public ResponseEntity<?> authenticateAccount(JwtRequest loginRequest) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getAccountName());
        Authentication authentication = authenticationManager.authenticate((Authentication) userDetails);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetailsImpl.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetailsImpl.getAccountName(),
                roles));
    }


    public ResponseEntity<?> signupAccount(JwtRequest signupRequest) {

        // Check if the user already exists
        if (accountsService.checkIfAccountExists(signupRequest.getAccountName()))
            throw AllExceptions.AccountNameAlreadyExists();

        AccountsDTO accountsDTO = new AccountsDTO();

        // Hash the password
        String encodedPassword = webSecurityConfig.passwordEncoder().encode(signupRequest.getPassword());
        accountsDTO.setAccountPassword(encodedPassword);
        accountsDTO.setAccountName(signupRequest.getAccountName());
        accountsDTO.setCreationDate(LocalDateTime.now());

        AccountsDTO accountsDto = accountsService.createAccount(accountsDTO);

        Accounts newAccount = accountsMapper.toEntity(accountsDto);

        //Assign new account a default "ROLE_USER"
        RoleAssignmentDTO newRoleAssignment = new RoleAssignmentDTO();
        newRoleAssignment.setAccountsId(newAccount.getAccountId());
        newRoleAssignment.setRole(Roles.valueOf("ROLE_USER"));
        newRoleAssignment.setAssignedDate(LocalDateTime.now());

        roleAssignmentService.createRoleAssignment(newRoleAssignment);

        // Update the password in signupRequest object before calling authenticateAccount
        signupRequest.setPassword(encodedPassword);

        return authenticateAccount(signupRequest);
    }
}
