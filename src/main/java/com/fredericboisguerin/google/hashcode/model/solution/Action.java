package com.fredericboisguerin.google.hashcode.model.solution;

public interface Action {

    void execute();

    void accept(ActionVisitor visitor);
}
