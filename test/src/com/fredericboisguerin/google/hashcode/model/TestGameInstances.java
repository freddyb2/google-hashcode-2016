package com.fredericboisguerin.google.hashcode.model;

import com.fredericboisguerin.google.hashcode.model.Position;
import com.fredericboisguerin.google.hashcode.model.ProductItem;
import com.fredericboisguerin.google.hashcode.model.ProductType;
import com.fredericboisguerin.google.hashcode.model.Weight;

public interface TestGameInstances {
    Position ORIGIN_POSITION = new Position(0, 0);

    Weight FIVE_KILOGRAMS = new Weight(5);
    ProductType HEAVY_PRODUCT_TYPE = new ProductType(FIVE_KILOGRAMS);
    ProductItem HEAVY_PRODUCT_ITEM = new ProductItem(HEAVY_PRODUCT_TYPE);

    Weight ONE_KILOGRAM = new Weight(1);
    ProductType LIGHT_PRODUCT_TYPE = new ProductType(ONE_KILOGRAM);
    ProductItem LIGHT_PRODUCT_ITEM = new ProductItem(LIGHT_PRODUCT_TYPE);

}
