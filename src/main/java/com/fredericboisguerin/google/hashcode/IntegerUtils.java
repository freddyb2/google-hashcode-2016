package com.fredericboisguerin.google.hashcode;

public class IntegerUtils {

    public static long nextLong(double d) {
        double floor = Math.floor(d);
        long round = Math.round(floor);
        return (d - floor) > 0 ? round + 1 : round;
    }
}
