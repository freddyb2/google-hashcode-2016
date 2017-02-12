package com.fredericboisguerin.google.hashcode.model.solution;

import com.fredericboisguerin.google.hashcode.model.input.Drone;
import com.fredericboisguerin.google.hashcode.model.input.ProductType;
import com.fredericboisguerin.google.hashcode.model.input.Warehouse;

public abstract class AbstractLoadUnload implements Action {

   private final Drone drone;
   private final Warehouse warehouse;
   private final ProductType productType;
   private final int quantity;

    protected AbstractLoadUnload(Drone drone, Warehouse warehouse, ProductType productType, int quantity) {
        this.drone = drone;
        this.warehouse = warehouse;
        this.productType = productType;
        this.quantity = quantity;
    }

    public Drone getDrone() {
        return drone;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public ProductType getProductType() {
        return productType;
    }

    public int getQuantity() {
        return quantity;
    }
}
