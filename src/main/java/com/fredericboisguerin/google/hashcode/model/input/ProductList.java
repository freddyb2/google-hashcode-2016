package com.fredericboisguerin.google.hashcode.model.input;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.fredericboisguerin.google.hashcode.StringUtils;

public class ProductList {
    private final Map<ProductType, Integer> productTypeQuantityMap = new HashMap<>();

    public void add(ProductType productType, int quantity) {
        assert quantity > 0;
        productTypeQuantityMap.compute(productType,
                (key, value) -> value == null ? quantity : value + quantity);
    }

    public Set<ProductType> getProductTypes() {
        return productTypeQuantityMap.keySet();
    }

    public int getQuantityFor(ProductType productType) {
        return productTypeQuantityMap.getOrDefault(productType, 0);
    }

    @Override
    public String toString() {
        return StringUtils.getTable(productTypeQuantityMap, "ProductId", "Quantity");
    }
}
