package com.onlydan.od.security.authentication;

import com.onlydan.od.dto.AccountsDTO;
import com.onlydan.od.exceptions.AllExceptions;
import com.onlydan.od.security.service.dto.RoleAssignmentDTO;
import com.onlydan.od.security.service.impl.UserDetailsImpl;
import com.onlydan.od.security.jwt.JwtRequest;
import com.onlydan.od.security.jwt.JwtResponse;
import com.onlydan.od.security.jwt.JwtUtils;
import com.onlydan.od.services.AccountsService;
import com.onlydan.od.services.RoleAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AuthResource implements AuthAPI {

    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    private final AccountsService accountsService;

    private final BCryptPasswordEncoder passwordEncoder;

    private final RoleAssignmentService roleAssignmentService;

    public ResponseEntity<?> authenticateAccount(JwtRequest loginRequest) {

        Authentication authentication =
                authenticationManager.authenticate
                        (new UsernamePasswordAuthenticationToken(
                                loginRequest.getAccountName(),
                                loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getAccountName(),
                roles));
    }

    public ResponseEntity<?> signupAccount(JwtRequest signupRequest) {

        // Check if the user already exists
        if (accountsService.getAccountByAccountName(signupRequest.getAccountName()) != null)
            return ResponseEntity.badRequest().body(AllExceptions.NameAlreadyExists());

        // Hash the password and create a new user
        AccountsDTO accountsDTO = new AccountsDTO();
        String encodedPassword = passwordEncoder.encode(signupRequest.getPassword());
        accountsDTO.setAccountPassword(encodedPassword);
        accountsDTO.setAccountName(signupRequest.getAccountName());
        accountsService.createAccount(accountsDTO);

        //TO DO: create RoleAssignment service
        RoleAssignmentDTO newRoleAssignment = new RoleAssignmentDTO();
        newRoleAssignment.setAccounts(accountsDTO); // Assuming setAccounts() takes AccountsDTO as a parameter
        newRoleAssignment.setRole("ROLE_USER"); // Set the user's role, e.g., ROLE_USER
        roleAssignmentService.createRoleAssignment(newRoleAssignment);

        UserDetailsImpl newUserDetails = UserDetailsImpl.build(accountsDTO);

        return ResponseEntity.ok(newUserDetails);
    }
}
