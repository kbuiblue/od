package com.onlydan.od.security.entity;

public enum Roles {
    ADMIN(1),
    USER(2);

    private final int value;

    Roles(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
