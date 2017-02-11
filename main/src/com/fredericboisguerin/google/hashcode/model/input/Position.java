package com.fredericboisguerin.google.hashcode.model.input;

public class Position {

    private final int row;
    private final int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public long distanceTo(Position position) {
        int deltaRow = row - position.row;
        int deltaColumn = column - position.column;
        double norm2 = Math.sqrt(square(deltaRow) + square(deltaColumn));
        double floor = Math.floor(norm2);
        long round = Math.round(floor);
        return (norm2 - floor) > 0 ? round + 1 : round;
    }

    private static double square(int value) {
        return Math.pow(value, 2);
    }
}
