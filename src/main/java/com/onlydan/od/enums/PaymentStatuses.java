package com.onlydan.od.enums;

public enum PaymentStatuses {
    NOT_PAID(1),
    PROCESSING(2),
    PAYMENT_FAILED(3),
    PAID(4);

    private final int value;

    PaymentStatuses(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
