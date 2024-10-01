package ru.nsu;

import java.util.HashMap;

abstract class Expression {
    abstract int eval(HashMap<String, Integer> vars);
    abstract Expression derivative(String var);
    abstract Expression copy();
    abstract public String toString();
    public int eval(String vars) {
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
