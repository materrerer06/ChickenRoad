package org.example.domain.exceptions;

public class OutOfBoundException extends RuntimeException {
    public OutOfBoundException(String message) {
        super(message);
    }
}
