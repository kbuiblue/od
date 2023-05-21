package com.onlydan.od.enums;

public enum InventoryStatuses {
    IN_STOCK(1),
    OUT_OF_STOCK(2),
    ON_SALE(3),
    UNAVAILABLE(4);

    private final int value;

    InventoryStatuses(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
