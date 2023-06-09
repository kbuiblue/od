package com.onlydan.od.enums;

public enum ShippingStatuses {
    STARTED(1),
    IN_TRANSIT(2),
    RETURNING(3),
    DELIVERED(4);

    private final int value;

    ShippingStatuses(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
