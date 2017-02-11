package com.fredericboisguerin.google.hashcode.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Order {

    private final Position deliveryPosition;
    private final Map<ProductType, Integer> productTypeQuantityMap = new HashMap<>();

    public Order(Position deliveryPosition) {
        this.deliveryPosition = deliveryPosition;
    }

    public void add(ProductType productType, int quantity) {
        assert quantity > 0;
        productTypeQuantityMap.compute(productType, (key, value) -> value == null ? quantity : value + quantity);
    }

    public Set<ProductType> getProductTypes() {
        return productTypeQuantityMap.keySet();
    }

    public int getQuantityFor(ProductType productType) {
        return productTypeQuantityMap.getOrDefault(productType, 0);
    }
}