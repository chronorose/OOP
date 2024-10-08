package ru.nsu;

class ParserNumber extends ParserExpr {
    int number;

    ParserNumber(int number) {
        super(ParType.Num);
        this.number = number;
    }

    public String toString() {
        return String.valueOf(number);
    }
}
