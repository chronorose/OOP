package ru.nsu;

class Main {
    public static void main(String[] args) {
        Expression e = new Mul(new Variable("kek"), new Number(1));
        try {
            int i = e.eval("kek= 32");
            System.out.println(i);
        } catch (Exception ex) {
            System.out.println("hehe");
        }
        System.out.println(e.toString());
        String str = "2 * A + 2 * A";
        Expression exprs = Parser.parse(str).simplify();
        System.out.println(exprs);
    }
}
