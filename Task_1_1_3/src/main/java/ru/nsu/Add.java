package ru.nsu;

import java.util.HashMap;

class Add extends Binary {
    Add(Expression left, Expression right) {
        super(left, right);
    }

    protected int eval(HashMap<String, Integer> vars) {
        return left.eval(vars) + right.eval(vars);
    }

    protected int eval() {
        return left.eval() + right.eval();
    }

    public Expression derivative(String var) {
        return new Add(left.derivative(var), right.derivative(var));
    }

    public Expression simplify() {
        if (!hasVar()) {
            return new Number(eval());
        }
        return new Add(left.simplify(), right.simplify());
    }

    @Override
    public Expression copy() {
        return new Add(left.copy(), right.copy());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj.getClass() != this.getClass()) {
            return false;
        }
        Add add = (Add) obj;
        return left.equals(add.left) && right.equals(add.right);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " + " + right.toString() + ")";
    }
}
