package ru.nsu;

abstract class ParserExpr {
    PType tp; 

    ParserExpr(PType tp) {
        this.tp = tp;
    }

    public abstract String toString();
}
