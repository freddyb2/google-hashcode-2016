package com.fredericboisguerin.google.hashcode.model.input;

import com.fredericboisguerin.google.hashcode.IntegerUtils;

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
        return IntegerUtils.nextLong(norm2);
    }

    @Override
    public String toString() {
        return String.format("[r=%d, c=%d]", row, column);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Position position = (Position) o;

        if (row != position.row)
            return false;
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
