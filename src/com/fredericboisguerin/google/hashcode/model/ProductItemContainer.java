package com.fredericboisguerin.google.hashcode.model;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

class ProductItemContainer {
    private final Set<ProductItem> productItems = new HashSet<>();

    public Weight getWeight() {
        return productItems.stream()
                           .map(ProductItem::getWeight)
                           .reduce(Weight::add)
                           .orElseGet(Weight::zero);
    }

    public void load(ProductItem productItem) {
        productItems.add(productItem);
    }

    public ProductItem unload(ProductType productType) {
        Predicate<ProductItem> predicate = productItem -> productItem.isProductOfType(productType);
        Optional<ProductItem> itemOptional = productItems.stream()
                                                         .filter(predicate)
                                                         .findFirst();
        ProductItem productItem = itemOptional.orElseThrow(IllegalStateException::new);
        productItems.remove(productItem);
        return productItem;
    }
}
