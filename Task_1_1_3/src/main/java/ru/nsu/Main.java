package ru.nsu;

class Main {
    public static void main(String[] args) {
        Expression e = new Mul(new Variable("kek"), new Number(3));
        int i = e.eval("kek = 32");
        System.out.println(e.toString());
        System.out.println(i);

    }
}
