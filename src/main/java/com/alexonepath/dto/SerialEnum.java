package com.alexonepath.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SerialEnum {
    ACCOUNT(1),
    TRANSACTION_BONDING(2),
    TRANSACTION_DELEGATING(3);

    private int value;

    SerialEnum(int value) {
        this.value = value;
    }

    @JsonCreator
    public static SerialEnum fromValue(int value) {
        switch (value) {
            case 1:
                return ACCOUNT;
            case 2:
                return TRANSACTION_BONDING;
            case 3:
                return TRANSACTION_DELEGATING;
        }
        return null;
    }

    @JsonValue
    public int toValue() {
        return this.value;
    }
}
