package com.onlydan.od.security.jwt;

import java.io.Serializable;
import java.util.Set;

public class JwtResponse implements Serializable {

    private String token;
    private String type = "Bearer";
    private String accountName;
    private Set<String> roles;

    public JwtResponse(String accessToken, String accountName, Set<String> roles) {
        this.token = accessToken;
        this.accountName = accountName;
        this.roles = roles;
    }
}
