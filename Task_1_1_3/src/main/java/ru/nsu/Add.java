package ru.nsu;

import java.util.HashMap;

class Add extends Binary {
    Add(Expression left, Expression right) {
        super(left, right);
    }
    int eval(HashMap<String, Integer> vars) {
        return left.eval(vars) + right.eval(vars);
    }
    Expression derivative(String var) {
        return new Add(left.derivative(var), right.derivative(var));
    }
    @Override
    Expression copy() {
        return new Add(left.copy(), right.copy());
    }
    @Override
    public String toString() {
        return "(" + left.toString() + " + " + right.toString() + ")";
    }
}
