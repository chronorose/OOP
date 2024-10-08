package ru.nsu;

abstract class ParserExpr {
    ParType tp; 

    ParserExpr(ParType tp) {
        this.tp = tp;
    }

    public abstract String toString();
}
