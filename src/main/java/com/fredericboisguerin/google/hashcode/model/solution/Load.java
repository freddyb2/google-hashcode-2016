package com.fredericboisguerin.google.hashcode.model.solution;

import com.fredericboisguerin.google.hashcode.model.input.Drone;
import com.fredericboisguerin.google.hashcode.model.input.ProductItem;
import com.fredericboisguerin.google.hashcode.model.input.ProductItemContainer;
import com.fredericboisguerin.google.hashcode.model.input.ProductType;
import com.fredericboisguerin.google.hashcode.model.input.Warehouse;

public class Load extends AbstractLoadUnload {

    protected Load(Drone drone, Warehouse warehouse, ProductType productType, int quantity) {
        super(drone, warehouse, productType, quantity);
    }

    @Override
    public void execute() {
        Warehouse warehouse = getWarehouse();
        ProductItemContainer warehouseContainer = warehouse.getProductItemContainer();
        for (int i = 0; i < getQuantity(); i++) {
            ProductItem productItem = warehouseContainer.unload(getProductType());
            getDrone().load(productItem);
        }
    }

    @Override
    public void accept(ActionVisitor visitor) {
        visitor.visit(this);
    }
}
