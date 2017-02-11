package com.fredericboisguerin.google.hashcode.model.input;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertTrue;

public class GameTest {

    private static final HashSet<Drone> A_DRONE_SET = new HashSet<>();
    private static final HashSet<Warehouse> A_WAREHOUSE_SET = new HashSet<>();
    private static final HashSet<Order> AN_ORDER_SET = new HashSet<>();
    private static final Weight TEN_KILOS = new Weight(10);


    private Game game;

    @Before
    public void setUp() throws Exception {
        Order anOrder = new Order(TestGameInstances.ORIGIN_POSITION);
        AN_ORDER_SET.add(anOrder);
        Warehouse aWarehouse = new Warehouse(TestGameInstances.ORIGIN_POSITION);
        A_WAREHOUSE_SET.add(aWarehouse);
        A_DRONE_SET.add(new Drone(TEN_KILOS));
    }

    @Test
    public void name() throws Exception {
        int turns = 42;
        game = new Game(turns, TEN_KILOS, A_DRONE_SET, A_WAREHOUSE_SET, AN_ORDER_SET);

        assertTrue(game.getTurns() == turns);
        assertTrue(game.getMaximumChargeForDrones() == TEN_KILOS);
        assertTrue(game.getDrones().equals(A_DRONE_SET));
        assertTrue(game.getWarehouses().equals(A_WAREHOUSE_SET));
        assertTrue(game.getOrders().equals(AN_ORDER_SET));
    }
}