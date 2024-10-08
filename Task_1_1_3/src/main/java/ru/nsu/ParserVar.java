package ru.nsu;

class ParserVar extends ParserExpr {
    String var;

    ParserVar(String str) {
        super(ParType.Var);
        var = str;
    }
}
