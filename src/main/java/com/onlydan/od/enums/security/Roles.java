package com.onlydan.od.enums.security;

public enum Roles {
    ROLE_ADMIN(1),
    ROLE_USER(2);

    private final int value;

    Roles(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public String getName() {
        return name();
    }
}
