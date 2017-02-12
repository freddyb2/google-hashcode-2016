package com.fredericboisguerin.google.hashcode.model.solution;

import com.fredericboisguerin.google.hashcode.model.input.Drone;

public class Wait implements DroneAction {
    private final Drone drone;
    private final int nbTurns;

    public Wait(Drone drone, int nbTurns) {
        this.drone = drone;
        this.nbTurns = nbTurns;
    }

    public Drone getDrone() {
        return drone;
    }

    public int getNbTurns() {
        return nbTurns;
    }

    @Override
    public void execute() {
        // Nothing to do
    }

    @Override
    public void accept(ActionVisitor visitor) {
        visitor.visit(this);
    }
}
