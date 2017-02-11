package com.fredericboisguerin.google.hashcode.parser;

import com.fredericboisguerin.google.hashcode.model.input.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class StringsGameParser {

    private static final String SPACE = " ";

    public Game parse(List<String> lines) {
        OneTimeParser oneTimeParser = new OneTimeParser(lines);
        return oneTimeParser.parse();
    }

    private class OneTimeParser {
        private final List<String> lines;
        private int line;

        private OneTimeParser(List<String> lines) {
            this.lines = lines;
        }

        public Game parse() {
            // Parameters
            int[] parameters = getIntArray();
            int nbRows = parameters[0];
            int nbColumns = parameters[1];
            int nbDrones = parameters[2];
            int nbTurnsMax = parameters[3];
            int maximumLoadOfDroneInt = parameters[4];
            Weight weightmaximumLoadOfDrone = new Weight(maximumLoadOfDroneInt);

            Set<Drone> drones = getSetOfDrones(nbDrones, weightmaximumLoadOfDrone);

            // Product types
            int nbProductTypes = getInt();
            int[] productTypeWeights = getIntArray();

            List<ProductType> productTypes = getProductTypes(productTypeWeights);

            // Warehouses
            Set<Warehouse> warehouses = new HashSet<>();
            int warehousesCardinal = getInt();
            for (int i = 0; i < warehousesCardinal; i++) {
                int[] coords = getIntArray();
                int row = coords[0];
                int column = coords[1];
                Position position = new Position(row, column);
                Warehouse warehouse = new Warehouse(position);
                warehouses.add(warehouse);
                ProductItemContainer container = warehouse.getProductItemContainer();
                int[] productTypeQuantities = getIntArray();
                for (int j = 0; j < nbProductTypes; j++) {
                    ProductType productType = productTypes.get(j);
                    int quantity = productTypeQuantities[j];
                    addProductItemsToContainer(quantity, productType, container::load);
                }
            }

            // Orders
            Set<Order> orders = new HashSet<>();
            int nbOrders = getInt();
            for (int i = 0; i < nbOrders; i++) {
                int[] coords = getIntArray();
                int row = coords[0];
                int column = coords[1];
                Position deliveryPosition = new Position(row, column);
                Order order = new Order(deliveryPosition);
                orders.add(order);
                int nbOfProductItems = getInt();
                int[] products = getIntArray();
                for (int j = 0; j < nbOfProductItems; j++) {
                    int productId = products[j];
                    ProductType productType = productTypes.get(productId);
                    order.add(productType, 1);
                }
            }

            return new Game(nbTurnsMax, weightmaximumLoadOfDrone, drones, warehouses, orders);
        }

        private int[] getIntArray() {
            String line = getLine();
            String[] strings = getElements(line);
            return asIntegerArray(strings);
        }

        private int getInt() {
            String s = getLine();
            return asInt(s);
        }

        private String getLine() {
            return lines.get(line++);
        }
    }

    private void addProductItemsToContainer(int quantity, ProductType productType, Consumer<ProductItem> productItemConsumer) {
        IntStream.range(0, quantity)
                 .boxed()
                 .map(k -> new ProductItem(productType))
                 .forEach(productItemConsumer);
    }

    private static List<ProductType> getProductTypes(int[] productTypeWeights) {
        return Arrays.stream(productTypeWeights)
                     .boxed()
                     .map(StringsGameParser::getProductType)
                     .collect(Collectors.toList());
    }

    private static ProductType getProductType(int weight) {
        Weight productWeight = new Weight(weight);
        return new ProductType(productWeight);
    }

    private static Set<Drone> getSetOfDrones(int nbDrones, Weight maximumLoadOfDrone) {
        return IntStream.range(0, nbDrones)
                        .boxed()
                        .map(i -> new Drone(maximumLoadOfDrone))
                        .collect(Collectors.toSet());
    }

    private static int[] asIntegerArray(String[] strings) {
        int[] array = new int[strings.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = asInt(strings[i]);
        }
        return array;
    }

    private static String[] getElements(String line) {
        return line.split(SPACE);
    }

    private static Integer asInt(String s) {
        return Integer.valueOf(s);
    }
}
