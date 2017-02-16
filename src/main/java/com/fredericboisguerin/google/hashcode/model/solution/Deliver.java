package com.fredericboisguerin.google.hashcode.model.solution;

import com.fredericboisguerin.google.hashcode.model.input.Drone;
import com.fredericboisguerin.google.hashcode.model.input.Order;
import com.fredericboisguerin.google.hashcode.model.input.ProductType;

public class Deliver implements Action {

    private final Drone drone;
    private final Order order;
    private final ProductType productType;
    private final int quantity;

    public Deliver(Drone drone, Order order, ProductType productType, int quantity) {
        this.drone = drone;
        this.order = order;
        this.productType = productType;
        this.quantity = quantity;
    }

    public Drone getDrone() {
        return drone;
    }

    public Order getOrder() {
        return order;
    }

    public ProductType getProductType() {
        return productType;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public void execute() {
        ProductType productType = getProductType();
        int quantity = getQuantity();
        for (int i = 0; i < quantity; i++) {
            getDrone().unload(productType);
        }
    }

    @Override
    public void accept(ActionVisitor visitor) {
        visitor.visit(this);
    }
}
