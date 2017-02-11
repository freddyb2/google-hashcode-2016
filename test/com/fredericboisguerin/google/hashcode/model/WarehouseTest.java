package com.fredericboisguerin.google.hashcode.model;

import org.junit.Before;
import org.junit.Test;

import static com.fredericboisguerin.google.hashcode.model.TestGameInstances.ORIGIN_POSITION;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class WarehouseTest {

    private Warehouse warehouse;

    @Before
    public void setUp() throws Exception {
        warehouse = new Warehouse(ORIGIN_POSITION);
    }

    @Test
    public void should_warehouse_position_equals_origin() throws Exception {
        Position position = warehouse.getPosition();

        assertTrue(position == ORIGIN_POSITION);
    }

    @Test
    public void should_warehouse_container_must_not_be_null() throws Exception {
        ProductItemContainer productItemContainer = warehouse.getProductItemContainer();

        assertNotNull(productItemContainer);
    }
}