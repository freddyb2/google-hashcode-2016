package com.fredericboisguerin.google.hashcode.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class OrderTest {

    private Order order;

    @Before
    public void setUp() throws Exception {
        order = new Order(TestGameInstances.ORIGIN_POSITION);
    }

    @Test
    public void should_return_the_product_types_of_the_added_items() throws Exception {
        order.add(TestGameInstances.LIGHT_PRODUCT_TYPE, 2);

        Set<ProductType> productTypes = order.getProductTypes();

        assertTrue(productTypes.contains(TestGameInstances.LIGHT_PRODUCT_TYPE));
    }

    @Test
    public void should_return_the_quantity_of_the_added_items() throws Exception {
        int two = 2;
        order.add(TestGameInstances.LIGHT_PRODUCT_TYPE, two);

        int quantity = order.getQuantityFor(TestGameInstances.LIGHT_PRODUCT_TYPE);

        assertThat(quantity, is(two));
    }

    @Test
    public void should_return_0_as_quantity_if_no_item() throws Exception {
        int quantity = order.getQuantityFor(TestGameInstances.LIGHT_PRODUCT_TYPE);

        assertThat(quantity, is(0));
    }
}