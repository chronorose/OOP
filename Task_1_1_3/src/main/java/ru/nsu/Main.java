package ru.nsu;

import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Expression e = new Mul(new Variable("kek"), new Number(3));
        int i = e.eval("kek = 32");
        System.out.println(e.toString());
        System.out.println(i);
        String str = "4 * A + B";
        ArrayList<Expression> exprs = Parser.parse(str);
        for (int j = 0; j < exprs.size(); j++) {
            Expression expr = exprs.get(j);
            System.out.println(expr.toString());
        }
    }
}
