package com.onlydan.od.security.jwt;

import java.io.Serializable;
import java.util.List;

public class JwtResponse implements Serializable {

    private String token;
    private String type = "Bearer";
    private String accountName;
    private List<String> roles;

    public JwtResponse(String accessToken, String accountName, List<String> roles) {
        this.token = accessToken;
        this.accountName = accountName;
        this.roles = roles;
    }
}
