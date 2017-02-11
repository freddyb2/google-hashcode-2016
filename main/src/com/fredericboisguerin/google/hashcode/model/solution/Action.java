package com.fredericboisguerin.google.hashcode.model.solution;

public interface Action {

    void accept(ActionVisitor visitor);
}
