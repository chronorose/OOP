package ru.nsu;

class IncorrectInputException extends RuntimeException {
    String info;

    public IncorrectInputException() {}

    public IncorrectInputException(String info) {
        this.info = info;
    }
}
