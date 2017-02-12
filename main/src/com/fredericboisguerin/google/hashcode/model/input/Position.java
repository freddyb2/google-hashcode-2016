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

    @Override
    public String toString() {
        return String.format("[r=%d, c=%d]", row, column);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (row != position.row) return false;
        return column == position.column;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + column;
        return result;
    }

    private static double square(int value) {
        return Math.pow(value, 2);
    }
}
