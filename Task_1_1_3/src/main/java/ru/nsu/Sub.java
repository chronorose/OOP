package ru.nsu;

import java.util.HashMap;

class Sub extends Binary {
    Sub(Expression left, Expression right) {
        super(left, right);
    }

    protected int eval(HashMap<String, Integer> vars) {
        return left.eval(vars) - right.eval(vars);
    }

    protected int eval() {
        return left.eval() - right.eval();
    }

    public Expression derivative(String var) {
        return new Sub(left.derivative(var), right.derivative(var));
    }

    public Expression simplify() {
        Expression l = left.simplify();
        Expression r = right.simplify();
        if (l.equals(r)) {
            return new Number(0);
        }
        if (!l.hasVar() && !r.hasVar()) {
            return new Number(l.eval() - r.eval());
        }
        return new Sub(l, r);
    }

    @Override
    public Expression copy() {
        return new Sub(left.copy(), right.copy());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj.getClass() != this.getClass()) {
            return false;
        }
        Sub sub = (Sub) obj;
        return left.equals(sub.left) && right.equals(sub.right);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " - " + right.toString() + ")";
    }
}
