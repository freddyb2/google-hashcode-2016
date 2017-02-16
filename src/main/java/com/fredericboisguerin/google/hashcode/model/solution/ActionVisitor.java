package com.fredericboisguerin.google.hashcode.model.solution;

public interface ActionVisitor {
    void visit(Load load);

    void visit(Unload unload);

    void visit(Deliver deliver);

    void visit(Wait wait);
}
