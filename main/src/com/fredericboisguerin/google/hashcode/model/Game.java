package com.fredericboisguerin.google.hashcode.model;

import java.util.Collections;
import java.util.Set;

public class Game {

    private final int turns;
    private final Weight maximumChargeForDrones;
    private final Set<Drone> drones;
    private final Set<Warehouse> warehouses;
    private final Set<Order> orders;

    public Game(int turns, Weight maximumChargeForDrones, Set<Drone> drones, Set<Warehouse> warehouses, Set<Order> orders) {
        this.turns = turns;
        this.maximumChargeForDrones = maximumChargeForDrones;
        this.drones = Collections.unmodifiableSet(drones);
        this.warehouses = Collections.unmodifiableSet(warehouses);
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

    public Set<Warehouse> getWarehouses() {
        return warehouses;
    }

    public Set<Order> getOrders() {
        return orders;
    }
}
