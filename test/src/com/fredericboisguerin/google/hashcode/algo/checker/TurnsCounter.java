package com.fredericboisguerin.google.hashcode.algo.checker;

class TurnsCounter {
    private final long maxTurns;
    private long count = 0;

    public TurnsCounter(long maxTurns) {
        this.maxTurns = maxTurns;
    }

    public void inc() {
        inc(1);
    }

    public void inc(long turns) {
        if (this.count + turns > maxTurns) {
            throw new IllegalStateException("Maximum of turns reached!");
        }
        count += turns;
    }
}
