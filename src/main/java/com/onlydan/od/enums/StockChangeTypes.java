package com.onlydan.od.enums;

public enum StockChangeTypes {
    OUTGOING(0),
    INCOMING(1);

    private final int value;

    StockChangeTypes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
