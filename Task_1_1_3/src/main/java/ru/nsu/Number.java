package ru.nsu;

import java.util.HashMap;

class Number extends Expression {
    int number;
    Number(int number) {
        this.number = number;
    }
    int eval(HashMap<String, Integer> vars) {
        return number; 
    }
    Expression derivative(String var) {
        return new Number(0);
    }
    @Override
    Expression copy() {
        return new Number(number);
    }
    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
