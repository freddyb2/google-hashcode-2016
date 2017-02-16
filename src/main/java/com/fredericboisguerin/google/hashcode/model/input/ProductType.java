package com.fredericboisguerin.google.hashcode.model.input;

public class ProductType {
    private final Weight weight;

    public ProductType(Weight weight) {
        this.weight = weight;
    }

    public Weight getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return Integer.toString(hashCode());
    }
}
