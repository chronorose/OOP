package ru.nsu;

import java.util.HashMap;

class Number extends Expression {
    int number;

    Number(int number) {
        this.number = number;
    }

    protected int eval(HashMap<String, Integer> vars) {
        return number; 
    }

    protected int eval() {
        return number; 
    }

    public Expression derivative(String var) {
        return new Number(0);
    }

    protected boolean hasVar() {
        return false;
    }
    
    public Expression simplify() {
        return new Number(number);
    }

    @Override
    public Expression copy() {
        return new Number(number);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj.getClass() != this.getClass()) {
            return false;
        }
        Number var = (Number) obj;
        return number == var.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
