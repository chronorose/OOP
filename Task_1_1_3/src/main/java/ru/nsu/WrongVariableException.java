package ru.nsu;

class WrongVariableException extends RuntimeException {
    String reason;

    public WrongVariableException() {}

    public WrongVariableException(String reason) {
        this.reason = reason;
    }
}
