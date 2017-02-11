package com.fredericboisguerin.google.hashcode.model;

public class Weight {

    private final int value;

    public Weight(int value) {
        this.value = value;
    }

    public static Weight zero() {
        return new Weight(0);
    }

    public Weight add(Weight other) {
        return new Weight(value + other.value);
    }

    public boolean isLighterThan(Weight other) {
        return value <= other.value;
    }
}
