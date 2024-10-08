package ru.nsu;

class ParserVar extends ParserExpr {
    String var;

    ParserVar(String str) {
        super(PType.Var);
        var = str;
    }

    public String toString() {
        return var;
    }
}
