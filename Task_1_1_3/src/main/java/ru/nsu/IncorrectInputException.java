package ru.nsu;

class IncorrectInputException extends RuntimeException {
    String info;
    Throwable cause;
    public IncorrectInputException() {}

    public IncorrectInputException(String info) {
        this.info = info;
    }

    public IncorrectInputException(String info, Throwable cause) {
        this.info = info;
        this.cause = cause;
    }
}
