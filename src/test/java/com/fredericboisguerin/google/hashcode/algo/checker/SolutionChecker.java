package com.fredericboisguerin.google.hashcode.algo.checker;

import java.util.Set;

import com.fredericboisguerin.google.hashcode.model.input.Game;
import com.fredericboisguerin.google.hashcode.model.input.Order;
import com.fredericboisguerin.google.hashcode.model.input.Position;
import com.fredericboisguerin.google.hashcode.model.input.ProductList;
import com.fredericboisguerin.google.hashcode.model.input.ProductType;
import com.fredericboisguerin.google.hashcode.model.solution.Action;
import com.fredericboisguerin.google.hashcode.model.solution.Solution;

public class SolutionChecker {

    private static final String ORDER_INCOMPLETE_MESSAGE = "Order %s is not completely delivered. Missing %d product items of type %s";

    public long getScore(Game game, Solution solution) throws SolutionValidationException {
        Position firstWarehousePosition = game.getWarehouses().get(0).getPosition();
        DronesMonitor dronesMonitor = new DronesMonitor(firstWarehousePosition, game.getTurns());
        DeliveriesMonitor deliveriesMonitor = new DeliveriesMonitor();
        for (Action action : solution) {
            try {
                dronesMonitor.notifyBeforeAction(action);
                action.execute();
                deliveriesMonitor.notifyAfterAction(action);
            } catch (Exception e) {
                throw new SolutionValidationException(e);
            }
        }
        assertThat(forEachOrderIn(game), deliveryIsComplete(deliveriesMonitor));
        return computeScore(dronesMonitor.getMaxNbTurns(), game.getTurns());
    }

    private long computeScore(long effectiveTurns, long maxAuthorizedTurns) {
        return ((maxAuthorizedTurns - effectiveTurns) * 100) / maxAuthorizedTurns;
    }

    private void assertThat(Iterable<Order> orderIterator, OrderChecker orderChecker)
            throws SolutionValidationException {
        for (Order order : orderIterator) {
            orderChecker.check(order);
        }
    }

    private OrderChecker deliveryIsComplete(DeliveriesMonitor deliveriesMonitor) {
        return order -> {
            ProductList deliveredProductList = deliveriesMonitor.getDeliveredProductList(order);
            Set<ProductType> productTypes = order.getProductTypes();
            for (ProductType productType : productTypes) {
                int quantityOrdered = order.getQuantityFor(productType);
                int quantityDelivered = deliveredProductList.getQuantityFor(productType);
                if (quantityDelivered != quantityOrdered) {
                    String errorMessage = String.format(ORDER_INCOMPLETE_MESSAGE, order,
                            quantityOrdered - quantityDelivered, productType);
                    throw new SolutionValidationException(errorMessage);
                }
            }
        };
    }

    private Iterable<Order> forEachOrderIn(Game game) {
        return () -> game.getOrders().iterator();
    }

    private interface OrderChecker {
        void check(Order order) throws SolutionValidationException;
    }
}
