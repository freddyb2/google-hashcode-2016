package com.fredericboisguerin.google.hashcode.model;

import com.fredericboisguerin.google.hashcode.model.Position;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PositionTest {

    private final Position A = new Position(1, 1);
    private final Position B = new Position(2, 2);
    private final Position C = new Position(3, 3);

    private final Position D = new Position(0, 0);
    private final Position E = new Position(0, 2);

    @Test
    public void
    should_return_0_when_getRow_given_E() {
        int row = E.getRow();

        assertThat(row, is(0));
    }

    @Test
    public void
    should_return_0_when_getColumn_given_E() {
        int column = E.getColumn();

        assertThat(column, is(2));
    }

    @Test
    public void
    should_return_2_when_distance_between_A_and_B() {
        long distance = A.distanceTo(B);

        assertEquals(2, distance);
    }

    @Test
    public void
    should_return_2_when_distance_between_B_and_A() {
        long distance = B.distanceTo(A);

        assertEquals(2, distance);
    }

    @Test
    public void
    should_return_3_when_distance_between_A_and_C() {
        long distance = A.distanceTo(C);

        assertEquals(3, distance);
    }

    @Test
    public void
    should_return_2_when_distance_between_D_and_E() {
        long distance = D.distanceTo(E);

        assertEquals(2, distance);
    }
}