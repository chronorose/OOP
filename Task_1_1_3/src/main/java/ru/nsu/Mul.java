package ru.nsu;

import java.util.HashMap;

class Mul extends Binary {
    Mul(Expression left, Expression right) {
        super(left, right);
    }
    int eval(HashMap<String, Integer> vars) {
        return left.eval(vars) * right.eval(vars);
    }
    Expression derivative(String var) {
        Expression l = left.derivative(var);
        Expression r = right.derivative(var);
        Expression uv = new Mul(l, right.copy());
        Expression vu = new Mul(left.copy(), r);
        return new Add(uv, vu);
    }
    @Override
    Expression copy() {
        return new Mul(left.copy(), right.copy());
    }
    @Override
    public String toString() {
        return "(" + left.toString() + " * " + right.toString() + ")";
    }
}
