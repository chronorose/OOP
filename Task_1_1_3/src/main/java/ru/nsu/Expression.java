package ru.nsu;

import java.util.HashMap;

abstract class Expression {
    public abstract Expression derivative(String var);

    public abstract Expression copy();

    public abstract boolean equals(Object obj); 

    public abstract String toString();

    public abstract Expression simplify();

    protected abstract boolean hasVar();

    protected abstract int eval(HashMap<String, Integer> vars);

    protected abstract int eval();

    public int eval(String vars) {
        if (vars.equals("")) {
            return eval();
        }
        String[] strs = vars.split("; ");
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            String[] var = str.split(" = ");
            hm.put(var[0], Integer.valueOf(var[1]));
        }
        return eval(hm);
    }
}
