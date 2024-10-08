package ru.nsu;

import java.util.ArrayList;

class Parser { 
    private static void addToStack(ArrayList<ParserOp> opstack,
            ArrayList<ParserExpr> out, ParserOp expr) {
        if (opstack.isEmpty()) {
            opstack.add(expr);
            return;
        }
        do {
            ParserOp exp = opstack.get(opstack.size() - 1);
            if (expr.prec >= exp.prec) {
                break;
            }
            out.add(exp);
            opstack.remove(opstack.get(opstack.size() - 1));
        } while (!opstack.isEmpty());
        opstack.add(expr);
    }

    private static void addRightParenToStack(ArrayList<ParserOp> opstack,
            ArrayList<ParserExpr> out) {
        ParserOp exp = opstack.get(opstack.size() - 1);
        while (exp.op != '(') {
            opstack.remove(opstack.get(opstack.size() - 1));
            out.add(exp);
            exp = opstack.get(opstack.size() - 1);
        }
        opstack.remove(opstack.get(opstack.size() - 1));
    }

    private static Expression parOpToExpr(ParserOp expr, Expression e1, Expression e2) {
        Expression ret = null;
        switch (expr.op) {
            case '+':
                ret = new Add(e1, e2);
                break;
            case '-':
                ret = new Sub(e1, e2);
                break;
            case '*':
                ret = new Mul(e1, e2);
                break;
            case '/':
                ret = new Div(e1, e2);
                break;
            default:
                throw new IncorrectInputException();
        } 
        return ret;
    }

    private static Expression emitExpr(ArrayList<ParserExpr> out) {
        ArrayList<Expression> exprs = new ArrayList<>();
        for (int i = 0; i < out.size(); i++) {
            ParserExpr expr = out.get(i);
            switch (expr.tp) {
                case Var:
                    ParserVar var = (ParserVar) expr;
                    exprs.add(new Variable(var.var));
                    break;
                case Num:
                    ParserNumber num = (ParserNumber) expr;
                    exprs.add(new Number(num.number));
                    break;
                case Op:
                    Expression e1 = exprs.get(exprs.size() - 1);
                    Expression e2 = exprs.get(exprs.size() - 2);
                    exprs.remove(exprs.get(exprs.size() - 1));
                    exprs.remove(exprs.get(exprs.size() - 1));
                    exprs.add(parOpToExpr((ParserOp) expr, e2, e1));
                    break;
                default:
                    throw new IncorrectInputException();
            }
        }
        return exprs.get(exprs.size() - 1);
    }

    static Expression parse(String str) {
        char[] string = str.toCharArray();
        ArrayList<ParserExpr> out = new ArrayList<>();
        ArrayList<ParserOp> opstack = new ArrayList<>();
        for (int i = 0; i < string.length; i++) {
            switch (string[i]) {
                case ' ':
                    continue;
                case '(':
                    opstack.add(new ParserOp('(', 1));
                    break;
                case ')':
                    addRightParenToStack(opstack, out);
                    break;
                case '+':
                    addToStack(opstack, out, new ParserOp('+', 2));
                    break;
                case '-':
                    addToStack(opstack, out, new ParserOp('-', 2));
                    break;
                case '*':
                    addToStack(opstack, out, new ParserOp('*', 3));
                    break;
                case '/':
                    addToStack(opstack, out, new ParserOp('/', 3));
                    break;
                default:
                    if (Util.isDigit(string[i])) {
                        String number = String.valueOf(string[i]);
                        i++;
                        while (i < string.length && Util.isDigit(string[i])) {
                            number += string[i];
                            i++;
                        }
                        if (i < string.length) {
                            i--;
                        }
                        out.add(new ParserNumber(Integer.parseInt(number)));
                    } else if (Util.isLetter(string[i])) {
                        String var = String.valueOf(string[i]);
                        i++;
                        while (i < string.length && Util.isLetter(string[i])) {
                            var += string[i];
                            i++;
                        }
                        if (i < string.length) {
                            i--;
                        }
                        out.add(new ParserVar(var));
                    }
                    break;
            }
        }
        while (opstack.size() != 0) {
            ParserOp op = opstack.get(opstack.size() - 1);
            out.add(op);
            opstack.remove(opstack.get(opstack.size() - 1));
        }
        return emitExpr(out);
    }
}
