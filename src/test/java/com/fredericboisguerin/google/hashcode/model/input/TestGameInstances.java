package com.fredericboisguerin.google.hashcode.model.input;

public interface TestGameInstances {
    Position ORIGIN_POSITION = new Position(0, 0);

    Weight FIVE_KILOGRAMS = new Weight(5);
    ProductType HEAVY_PRODUCT_TYPE = new ProductType(FIVE_KILOGRAMS);
    ProductItem HEAVY_PRODUCT_ITEM = new ProductItem(HEAVY_PRODUCT_TYPE);

    Weight ONE_KILOGRAM = new Weight(1);
    ProductType LIGHT_PRODUCT_TYPE = new ProductType(ONE_KILOGRAM);
    ProductItem LIGHT_PRODUCT_ITEM = new ProductItem(LIGHT_PRODUCT_TYPE);

    String BUSY_DAY = "busy_day.in";
    String MOTHER_OF_ALL_WAREHOUSES = "mother_of_all_warehouses.in";
    String REDUNDANCY = "redundancy.in";
}
