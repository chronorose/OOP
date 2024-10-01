package ru.nsu;

import java.util.HashMap;

class Sub extends Binary {
    Sub(Expression left, Expression right) {
        super(left, right);
    }

    int eval(HashMap<String, Integer> vars) {
        return left.eval(vars) - right.eval(vars);
    }

    Expression derivative(String var) {
        return new Sub(left.derivative(var), right.derivative(var));
    }

    @Override
    Expression copy() {
        return new Mul(left.copy(), right.copy());
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " - " + right.toString() + ")";
    }
}
