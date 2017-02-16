package com.fredericboisguerin.google.hashcode.model.input;

public class ProductItem {

    private final ProductType productType;

    public ProductItem(ProductType productType) {
        this.productType = productType;
    }

    public boolean isProductOfType(ProductType productType) {
        return this.productType == productType;
    }

    public Weight getWeight() {
        return productType.getWeight();
    }
}
