package com.fredericboisguerin.google.hashcode.model.input;

import java.util.Set;

public class Order {

    private final Position deliveryPosition;
    private final ProductList orderedProductList = new ProductList();

    public Order(Position deliveryPosition) {
        this.deliveryPosition = deliveryPosition;
    }

    public Position getDeliveryPosition() {
        return deliveryPosition;
    }

    public void add(ProductType productType, int quantity) {
        orderedProductList.add(productType, quantity);
    }

    public Set<ProductType> getProductTypes() {
        return orderedProductList.getProductTypes();
    }

    public int getQuantityFor(ProductType productType) {
        return orderedProductList.getQuantityFor(productType);
    }
}
