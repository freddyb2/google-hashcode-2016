package com.fredericboisguerin.google.hashcode.algo.checker;

import com.fredericboisguerin.google.hashcode.model.input.Position;

class DroneMonitor {

    private final TurnsCounter turnsCounter;
    private Position currentPosition;

    public DroneMonitor(Position initialPosition, int maxTurns) {
        this.currentPosition = initialPosition;
        turnsCounter = new TurnsCounter(maxTurns);
    }

    public void doUnitAction() {
        inc();
    }

    public void moveTo(Position position) {
        inc(currentPosition.distanceTo(position));
        this.currentPosition = position;
    }

    public void waitFor(int nbTurns) {
        inc(nbTurns);
    }

    private void inc() {
        turnsCounter.inc();
    }

    private void inc(long turns) {
        turnsCounter.inc(turns);
    }
}
