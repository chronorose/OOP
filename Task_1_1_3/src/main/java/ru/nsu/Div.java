package ru.nsu;

import java.util.HashMap;

class Div extends Binary {
    Div(Expression left, Expression right) {
        super(left, right);
    }
    int eval(HashMap<String, Integer> vars) {
        return left.eval(vars) / right.eval(vars);
    }
    Expression derivative(String var) {
        Expression l = left.derivative(var);
        Expression r = right.derivative(var);
        Expression uv = new Mul(l, right.copy()); // u'v
        Expression vu = new Mul(left.copy(), r); // uv'
        Expression vsq = new Mul(right.copy(), right.copy()); // v^2
        Expression top = new Add(uv, vu); // u'v + uv'
        return new Div(top, vsq); // (u'v + uv') / v^2
    }
    @Override
    Expression copy() {
        return new Div(left.copy(), right.copy());
    }
    @Override
    public String toString() {
        return "(" + left.toString() + " / " + right.toString() + ")";
    }
}
