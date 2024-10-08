package ru.nsu;

class ParserOp extends ParserExpr {
    char op;
    int prec;

    ParserOp(char op, int prec) {
        super(ParType.Op);
        this.op = op;
        this.prec = prec;
    }

    public String toString() {
        return String.valueOf(op);
    }
}
