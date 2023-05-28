package com.onlydan.od.restapi.authentication;

import com.onlydan.od.entities.Accounts;
import com.onlydan.od.enums.security.Roles;
import com.onlydan.od.dto.security.RoleAssignmentDTO;
import com.onlydan.od.security.impl.UserDetailsImpl;
import com.onlydan.od.security.jwt.JwtRequest;
import com.onlydan.od.security.jwt.JwtResponse;
import com.onlydan.od.security.jwt.JwtUtils;
import com.onlydan.od.services.security.AuthService;
import com.onlydan.od.services.security.RoleAssignmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
public class AuthResource implements AuthAPI {

    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    private final AuthService authService;

    private final RoleAssignmentService roleAssignmentService;

    public ResponseEntity<?> authenticateAccount(JwtRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getAccountName(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        log.info(jwt);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getUsername(),
                roles));
    }


    public ResponseEntity<?> signupAccount(JwtRequest signupRequest) {

        Accounts newAccount = authService.createAccount(signupRequest);

        //Assign new account a default "ROLE_USER"
        RoleAssignmentDTO newRoleAssignment = new RoleAssignmentDTO();
        newRoleAssignment.setAccountId(newAccount.getAccountId());
        newRoleAssignment.setRole(Roles.valueOf("ROLE_USER"));
        newRoleAssignment.setAssignedDate(LocalDateTime.now());

        roleAssignmentService.createRoleAssignment(newRoleAssignment);

        return ResponseEntity.ok("Account created successfully");
    }
}
