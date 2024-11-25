package ru.nsu;

class WrongVariableException extends RuntimeException {
    String reason;
    Throwable cause;

    public WrongVariableException() {}

    public WrongVariableException(String reason) {
        this.reason = reason;
    }

    public WrongVariableException(String reason, Throwable cause) {
        this.reason = reason;
        this.cause = cause;
    }
}
