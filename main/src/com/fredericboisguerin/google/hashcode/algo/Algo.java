package com.fredericboisguerin.google.hashcode.algo;

import com.fredericboisguerin.google.hashcode.model.input.Game;
import com.fredericboisguerin.google.hashcode.model.solution.Solution;

public interface Algo {

    String getName();

    Solution getSolution(Game game);
}