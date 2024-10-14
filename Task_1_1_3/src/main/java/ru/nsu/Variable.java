package ru.nsu;

import java.util.HashMap;

class Variable extends Expression {
    String name;

    Variable(String name) {
        this.name = name;
    }

    protected int eval(HashMap<String, Integer> vars) {
        Integer number = vars.get(name);
        if (number == null) {
            throw new WrongVariableException(
                    "You have tried to evaluate expr with incorrect arguments"
                    + "(one of the variables was not initialized)."
                    + name);
        }
        return number;
    }

    protected int eval() {
        throw new WrongVariableException("Incorrect optimization took place.");
    }

    protected boolean hasVar() {
        return true;
    }

    public Expression simplify() {
        return new Variable(name);
    }

    public Expression derivative(String var) {
        if (name.equals(var)) {
            return new Number(1);
        }
        return new Number(0);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj.getClass() != this.getClass()) {
            return false;
        }
        Variable var = (Variable) obj;
        return name.equals(var.name);
    }

    @Override
    public Expression copy() {
        return new Variable(new String(name));
    }

    @Override
    public String toString() {
        return name;
    }
}
