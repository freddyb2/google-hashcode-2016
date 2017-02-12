package com.fredericboisguerin.google.hashcode.algo.checker;

import com.fredericboisguerin.google.hashcode.model.input.Drone;
import com.fredericboisguerin.google.hashcode.model.input.Position;
import com.fredericboisguerin.google.hashcode.model.solution.*;

import java.util.HashMap;
import java.util.Map;

class DronesMonitor {

    private final Map<Drone, DroneMonitor> monitoredDroneMap = new HashMap<>();
    private final InnerMonitor visitor = new InnerMonitor();
    private final Position initialPosition;
    private final int maxTurns;

    public DronesMonitor(Position initialPosition, int maxTurns) {
        this.initialPosition = initialPosition;
        this.maxTurns = maxTurns;
    }

    public long getMaxNbTurns() {
        return monitoredDroneMap.values()
                                .stream()
                                .map(DroneMonitor::getCount)
                                .max(Long::compareTo)
                                .orElse(0L);
    }

    public void notifyBeforeAction(Action action) {
        action.accept(visitor);
    }

    private class InnerMonitor implements ActionVisitor {

        @Override
        public void visit(Load load) {
            DroneMonitor droneMonitor = get(load.getDrone());
            droneMonitor.moveTo(load.getWarehouse().getPosition());
            droneMonitor.doUnitAction();
        }

        @Override
        public void visit(Unload unload) {
            DroneMonitor droneMonitor = get(unload.getDrone());
            droneMonitor.moveTo(unload.getWarehouse().getPosition());
            droneMonitor.doUnitAction();
        }

        @Override
        public void visit(Deliver deliver) {
            DroneMonitor droneMonitor = get(deliver.getDrone());
            droneMonitor.moveTo(deliver.getOrder().getDeliveryPosition());
            droneMonitor.doUnitAction();
        }

        @Override
        public void visit(Wait wait) {
            DroneMonitor droneMonitor = get(wait.getDrone());
            droneMonitor.waitFor(wait.getNbTurns());
        }
    }

    private DroneMonitor get(Drone drone) {
        return monitoredDroneMap.computeIfAbsent(drone, key -> new DroneMonitor(initialPosition, maxTurns));
    }
}
