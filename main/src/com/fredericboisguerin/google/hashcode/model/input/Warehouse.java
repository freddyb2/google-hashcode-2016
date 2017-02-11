package com.fredericboisguerin.google.hashcode.model.input;

public class Warehouse {

    private final Position position;
    private final ProductItemContainer productItemContainer = new ProductItemContainer();

    public Warehouse(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public ProductItemContainer getProductItemContainer() {
        return productItemContainer;
    }
}