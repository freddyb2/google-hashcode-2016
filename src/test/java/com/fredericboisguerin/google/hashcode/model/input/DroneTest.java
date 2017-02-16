package com.fredericboisguerin.google.hashcode.model.input;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DroneTest {

    private static final Drone LIGHT_DRONE = new Drone(TestGameInstances.ONE_KILOGRAM);

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_an_exception_if_trying_to_load_overweight() throws Exception {
        LIGHT_DRONE.load(TestGameInstances.HEAVY_PRODUCT_ITEM);
    }

    @Test
    public void should_load_and_unload_a_product_item_of_its_weight_capacity() throws Exception {
        LIGHT_DRONE.load(TestGameInstances.LIGHT_PRODUCT_ITEM);

        ProductItem unloadedProduct = LIGHT_DRONE.unload(TestGameInstances.LIGHT_PRODUCT_TYPE);

        assertTrue(unloadedProduct == TestGameInstances.LIGHT_PRODUCT_ITEM);
    }
}