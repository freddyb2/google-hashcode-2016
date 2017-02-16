package com.fredericboisguerin.google.hashcode.model.input;

public class Drone {
    private final Weight maximumLoad;
    private final ProductItemContainer productItemContainer = new ProductItemContainer();

    public Drone(Weight maximumLoad) {
        this.maximumLoad = maximumLoad;
    }

    public void load(ProductItem productItem) {
        if (!canSupport(productItem.getWeight())) {
            throw new IllegalArgumentException("I cannot support this weight!");
        }
        productItemContainer.load(productItem);
    }

    public ProductItem unload(ProductType productType) {
        return productItemContainer.unload(productType);
    }

    private boolean canSupport(Weight additionnalWeight) {
        Weight charge = productItemContainer.getWeight();
        Weight futureCharge = charge.add(additionnalWeight);
        return futureCharge.isLighterThan(maximumLoad);
    }
}
