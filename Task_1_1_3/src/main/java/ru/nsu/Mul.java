package ru.nsu;

import java.util.HashMap;

class Mul extends Binary {
    Mul(Expression left, Expression right) {
        super(left, right);
    }

    protected int eval(HashMap<String, Integer> vars) {
        return left.eval(vars) * right.eval(vars);
    }

    protected int eval() {
        return left.eval() * right.eval();
    }

    public Expression derivative(String var) {
        Expression l = left.derivative(var);
        Expression r = right.derivative(var);
        Expression uv = new Mul(l, right.copy());
        Expression vu = new Mul(left.copy(), r);
        return new Add(uv, vu);
    }

    private Expression simplifyHelper(Expression e1, Expression e2) {
        int res = e1.eval();
        if (res == 0) {
            return new Number(0);
        } else if (res == 1) {
            return e2; 
        }
        return new Mul(new Number(res), e2);
    }

    public Expression simplify() {
        Expression l = left.simplify();
        Expression r = right.simplify();
        boolean lvar = l.hasVar();
        boolean rvar = r.hasVar();
        if ((!lvar) && (!rvar)) {
            return new Number(l.eval() * r.eval());
        } else if (!lvar) {
            return simplifyHelper(l, r);
        } else if (!rvar) {
            return simplifyHelper(r, l);
        }
        return new Mul(l, r);
    }

    @Override
    public Expression copy() {
        return new Mul(left.copy(), right.copy());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj.getClass() != this.getClass()) {
            return false;
        }
        Mul mul = (Mul) obj;
        return left.equals(mul.left) && right.equals(mul.right);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " * " + right.toString() + ")";
    }
}
