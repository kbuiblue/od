package com.onlydan.od.authentication.impl;

import com.onlydan.od.authentication.AuthController;
import com.onlydan.od.entities.Accounts;
import com.onlydan.od.repositories.AccountsRepository;
import com.onlydan.od.repositories.RoleAssignmentRepository;
import com.onlydan.od.security.config.WebSecurityConfig;
import com.onlydan.od.security.entity.RoleAssignment;
import com.onlydan.od.security.entity.Roles;
import com.onlydan.od.security.service.impl.UserDetailsImpl;
import com.onlydan.od.security.jwt.JwtRequest;
import com.onlydan.od.security.jwt.JwtResponse;
import com.onlydan.od.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    private final WebSecurityConfig webSecurityConfig;

    private final AccountsRepository accountsRepository;

    private final RoleAssignmentRepository roleAssignmentRepository;
    public ResponseEntity<?> authenticateAccount(JwtRequest loginRequest) {

        Authentication authentication =
                authenticationManager.authenticate
                        (new UsernamePasswordAuthenticationToken(
                                loginRequest.getAccountName(),
                                loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        Set<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getAccountName(),
                roles));
    }

    public ResponseEntity<?> signupAccount(JwtRequest signupRequest) {
        // Check if the user already exists
        if (accountsRepository.findByAccountName(signupRequest.getAccountName()).isPresent())
            return ResponseEntity.badRequest().body("Username already exists");

        PasswordEncoder encoder = webSecurityConfig.passwordEncoder();
        // Hash the password and create a new user
        signupRequest.setPassword(encoder.encode(signupRequest.getPassword()));
        Accounts newAccount = new Accounts(signupRequest.getAccountName(), signupRequest.getPassword());
        accountsRepository.save(newAccount);

        RoleAssignment newRole = new RoleAssignment(Roles.ROLE_USER, newAccount);
        roleAssignmentRepository.save(newRole);

        Authentication authentication =
                authenticationManager.authenticate
                        (new UsernamePasswordAuthenticationToken(
                                signupRequest.getAccountName(),
                                signupRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        Set<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());

        // Return the JWT based on the new user
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getAccountName(),
                roles));
    }
}
