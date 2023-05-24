package com.onlydan.od.authentication;

import com.onlydan.od.security.jwt.JwtRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/auth")
public interface AuthController {
    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> authenticateAccount(@Valid @RequestBody JwtRequest loginRequest);
    @PostMapping("/signup")
    ResponseEntity<?> signupAccount(@RequestBody JwtRequest signupRequest);
}
