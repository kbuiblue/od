package com.onlydan.od.authentication.impl;

import com.onlydan.od.authentication.AuthController;
import com.onlydan.od.dto.AccountsDTO;
import com.onlydan.od.exceptions.AllExceptions;
import com.onlydan.od.repositories.RoleAssignmentRepository;
import com.onlydan.od.security.service.dto.RoleAssignmentDTO;
import com.onlydan.od.security.service.impl.UserDetailsImpl;
import com.onlydan.od.security.jwt.JwtRequest;
import com.onlydan.od.security.jwt.JwtResponse;
import com.onlydan.od.security.jwt.JwtUtils;
import com.onlydan.od.services.AccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    private final AccountsService accountsService;

    private final RoleAssignmentRepository roleAssignmentRepository;

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
        AccountsDTO newAccount = new AccountsDTO();
        newAccount.setPasswordWithHash(signupRequest.getPassword());
        newAccount.setAccountName(signupRequest.getAccountName());
        accountsService.createAccount(newAccount);

        //TO DO: create RoleAssignment service
        RoleAssignmentDTO defaultRole = new RoleAssignmentDTO();
        roleAssignmentService.setRole()

        UserDetailsImpl newUserDetails = UserDetailsImpl.build(newAccount);

        // Return a success message instead of JWT
        return ResponseEntity.ok(newUserDetails);
    }
}
