package com.onlydan.od.enums;

public enum Gender {
    MALE(0),
    FEMALE(1),
    NON_BINARY(2);

    private final int value;

    Gender(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
