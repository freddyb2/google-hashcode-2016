package com.fredericboisguerin.google.hashcode.model.solution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution implements Iterable<Action> {

    private final List<Action> actions = new ArrayList<>();

    public boolean add(Action action) {
        return actions.add(action);
    }

    @Override
    public Iterator<Action> iterator() {
        return actions.iterator();
    }
}
