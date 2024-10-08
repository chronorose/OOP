package ru.nsu;

import java.util.HashMap;

class Div extends Binary {
    Div(Expression left, Expression right) {
        super(left, right);
    }

    protected int eval(HashMap<String, Integer> vars) {
        return left.eval(vars) / right.eval(vars);
    }

    protected int eval() {
        return left.eval() / right.eval();
    }

    public Expression simplify() {
        Expression l = left.simplify();
        Expression r = right.simplify();
        boolean lvar = l.hasVar();
        boolean rvar = r.hasVar();
        if ((!lvar) && (!rvar)) {
            return new Number(l.eval() / r.eval());
        } else if (!lvar) {
            int res = l.eval();
            if (res == 0) {
                return new Number(0);
            }
            return new Div(new Number(res), r);
        }
        return new Div(l, r);
    }

    public Expression derivative(String var) {
        Expression l = left.derivative(var);
        Expression r = right.derivative(var);
        Expression uv = new Mul(l, right.copy()); // u'v
        Expression vu = new Mul(left.copy(), r); // uv'
        Expression vsq = new Mul(right.copy(), right.copy()); // v^2
        Expression top = new Add(uv, vu); // u'v + uv'
        return new Div(top, vsq); // (u'v + uv') / v^2
    }

    @Override
    public Expression copy() {
        return new Div(left.copy(), right.copy());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj.getClass() != this.getClass()) {
            return false;
        }
        Div div = (Div) obj;
        return left.equals(div.left) && right.equals(div.right);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " / " + right.toString() + ")";
    }
}
