package ru.nsu;

import java.util.HashMap;

class Variable extends Expression {
    String name;
    Variable(String name) {
        this.name = name;
    }
    int eval(HashMap<String, Integer> vars) {
        int number = vars.get(name);
        return number;
    }
    Expression derivative(String var) {
        if (name == var) {
            return new Number(1);
        }
        return new Number(0);
    }
    @Override
    Expression copy() {
        return new Variable(new String(name)) ;
    }
    @Override
    public String toString() {
        return name;
    }
}
