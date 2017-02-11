package com.fredericboisguerin.google.hashcode.model;

import org.junit.Test;

import static com.fredericboisguerin.google.hashcode.model.TestGameInstances.*;
import static org.junit.Assert.assertTrue;

public class DroneTest {

    private static final Drone LIGHT_DRONE = new Drone(ONE_KILOGRAM);

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_an_exception_if_trying_to_load_overweight() throws Exception {
        LIGHT_DRONE.load(HEAVY_PRODUCT_ITEM);
    }

    @Test
    public void should_load_and_unload_a_product_item_of_its_weight_capacity() throws Exception {
        LIGHT_DRONE.load(LIGHT_PRODUCT_ITEM);

        ProductItem unloadedProduct = LIGHT_DRONE.unload(LIGHT_PRODUCT_TYPE);

        assertTrue(unloadedProduct == LIGHT_PRODUCT_ITEM);
    }
}