package ru.nsu;

abstract class Binary extends Expression {
    Expression left;
    Expression right;

    Binary(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    protected boolean hasVar() {
        return left.hasVar() || right.hasVar();
    }

}
