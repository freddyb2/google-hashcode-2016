package com.fredericboisguerin.google.hashcode.model.solution;

import com.fredericboisguerin.google.hashcode.model.input.Drone;
import com.fredericboisguerin.google.hashcode.model.input.ProductType;
import com.fredericboisguerin.google.hashcode.model.input.Warehouse;

public class Unload extends AbstractLoadUnload {

    protected Unload(Drone drone, Warehouse warehouse, ProductType productType, int quantity) {
        super(drone, warehouse, productType, quantity);
    }

    @Override
    public void accept(ActionVisitor visitor) {
        visitor.visit(this);
    }
}
