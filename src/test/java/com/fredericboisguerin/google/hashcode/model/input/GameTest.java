package com.fredericboisguerin.google.hashcode.model.input;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private static final Set<Drone> A_DRONE_SET = new HashSet<>();
    private static final List<Warehouse> SOME_WAREHOUSES = new ArrayList<>();
    private static final Set<Order> AN_ORDER_SET = new HashSet<>();
    private static final Weight TEN_KILOS = new Weight(10);

    private Game game;

    @Before
    public void setUp() throws Exception {
        Order anOrder = new Order(TestGameInstances.ORIGIN_POSITION);
        AN_ORDER_SET.add(anOrder);
        Warehouse aWarehouse = new Warehouse(TestGameInstances.ORIGIN_POSITION);
        SOME_WAREHOUSES.add(aWarehouse);
        A_DRONE_SET.add(new Drone(TEN_KILOS));
    }

    @Test
    public void name() throws Exception {
        int turns = 42;
        game = new Game(turns, TEN_KILOS, A_DRONE_SET, SOME_WAREHOUSES, AN_ORDER_SET);

        assertTrue(game.getTurns() == turns);
        assertTrue(game.getMaximumChargeForDrones() == TEN_KILOS);
        assertTrue(game.getDrones().equals(A_DRONE_SET));
        assertTrue(game.getWarehouses().equals(SOME_WAREHOUSES));
        assertTrue(game.getOrders().equals(AN_ORDER_SET));
    }
}