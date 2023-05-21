package com.onlydan.od.enums;

public enum RoleNames {
    ADMIN(1),
    EDITOR(2),
    USER(3);

    private final int value;

    RoleNames(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
