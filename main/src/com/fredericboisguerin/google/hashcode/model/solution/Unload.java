package com.fredericboisguerin.google.hashcode.model.solution;

import com.fredericboisguerin.google.hashcode.model.input.*;

public class Unload extends AbstractLoadUnload {

    protected Unload(Drone drone, Warehouse warehouse, ProductType productType, int quantity) {
        super(drone, warehouse, productType, quantity);
    }

    @Override
    public void execute() {
        Warehouse warehouse = getWarehouse();
        ProductItemContainer warehouseContainer = warehouse
                .getProductItemContainer();
        ProductType productType = getProductType();
        for (int i = 0; i < getQuantity(); i++) {
            ProductItem productItem = getDrone().unload(productType);
            warehouseContainer.load(productItem);
        }
    }

    @Override
    public void accept(ActionVisitor visitor) {
        visitor.visit(this);
    }
}
