package com.fredericboisguerin.google.hashcode.model.input;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class WarehouseTest {

    private Warehouse warehouse;

    @Before
    public void setUp() throws Exception {
        warehouse = new Warehouse(TestGameInstances.ORIGIN_POSITION);
    }

    @Test
    public void should_warehouse_position_equals_origin() throws Exception {
        Position position = warehouse.getPosition();

        assertTrue(position == TestGameInstances.ORIGIN_POSITION);
    }

    @Test
    public void should_warehouse_container_must_not_be_null() throws Exception {
        ProductItemContainer productItemContainer = warehouse.getProductItemContainer();

        assertNotNull(productItemContainer);
    }
}