package com.fredericboisguerin.google.hashcode.model.input;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Game {

    private final int turns;
    private final Weight maximumChargeForDrones;
    private final Set<Drone> drones;
    private final List<Warehouse> warehouses;
    private final Set<Order> orders;

    public Game(int turns, Weight maximumChargeForDrones, Set<Drone> drones,
            List<Warehouse> warehouses, Set<Order> orders) {
        this.turns = turns;
        this.maximumChargeForDrones = maximumChargeForDrones;
        this.drones = Collections.unmodifiableSet(drones);
        this.warehouses = Collections.unmodifiableList(warehouses);
        this.orders = Collections.unmodifiableSet(orders);
    }

    public int getTurns() {
        return turns;
    }

    public Weight getMaximumChargeForDrones() {
        return maximumChargeForDrones;
    }

    public Set<Drone> getDrones() {
        return drones;
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public Set<Order> getOrders() {
        return orders;
    }
}
