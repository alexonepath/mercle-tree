package com.alexonepath.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Transaction implements Serializable {
    private int version;
    private byte[] type;

    public Transaction() {

    }

    public Transaction(int version, byte[] type) {
        this.version = version;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(version, that.version) &&
                Arrays.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(version);
        result = 31 * result + Arrays.hashCode(type);
        return result;
    }
}
