package com.fredericboisguerin.google.hashcode.algo.checker;

import com.fredericboisguerin.google.hashcode.model.input.Order;
import com.fredericboisguerin.google.hashcode.model.input.ProductList;
import com.fredericboisguerin.google.hashcode.model.input.ProductType;
import com.fredericboisguerin.google.hashcode.model.solution.*;

import java.util.HashMap;
import java.util.Map;

class DeliveriesMonitor {

    private final Map<Order, ProductList> orderProductListMap = new HashMap<>();
    private final InnerVisitor visitor = new InnerVisitor();

    public void notifyAfterAction(Action action){
        action.accept(visitor);
    }

    public ProductList getDeliveredProductList(Order order){
        return orderProductListMap.get(order);
    }

    private class InnerVisitor implements ActionVisitor {

        @Override
        public void visit(Load load) {
            // Don't check that
        }

        @Override
        public void visit(Unload unload) {
            // Don't check that
        }

        @Override
        public void visit(Deliver deliver) {
            Order order = deliver.getOrder();
            ProductType productType = deliver.getProductType();
            int quantity = deliver.getQuantity();
            notifyDelivery(order, productType, quantity);
        }

        @Override
        public void visit(Wait wait) {
            // Don't check that
        }
    }

    private void notifyDelivery(Order order, ProductType productType, int quantity) {
        ProductList productList = orderProductListMap.computeIfAbsent(order, key -> new ProductList());
        productList.add(productType, quantity);
    }
}