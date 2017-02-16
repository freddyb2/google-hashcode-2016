package com.fredericboisguerin.google.hashcode.algo.checker;

public class SolutionValidationException extends Exception {
    public SolutionValidationException(Exception cause) {
        super(cause);
    }

    public SolutionValidationException(String message) {
        super(message);
    }
}
