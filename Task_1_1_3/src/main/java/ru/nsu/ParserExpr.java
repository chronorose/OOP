package ru.nsu;

abstract class ParserExpr {
    PType tp; 
    ParserExpr(PType tp) {
        this.tp = tp;
    }
    abstract public String toString();
}
