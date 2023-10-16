package org.younes.arith.operator;

import org.younes.expression.operator.BinaryOperator;

public enum ArithmBinaryOperator implements BinaryOperator{
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;

    ArithmBinaryOperator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static ArithmBinaryOperator fromSymbol(String symbol) {
        for (ArithmBinaryOperator operator : ArithmBinaryOperator.values()) {
            if (operator.getSymbol().equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("Unknown operator: " + symbol);
    }

    public static boolean isArithmOperator(String symbol) {
        for (ArithmBinaryOperator operator : ArithmBinaryOperator.values()) {
            if (operator.getSymbol().equals(symbol)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOperator(String input) {
        for (ArithmBinaryOperator operator : ArithmBinaryOperator.values()) {
            if (operator.getSymbol().equals(input)) {
                return true;
            }
        }
        return false;
    }

    public double apply(double left, double right) {
        switch (this) {
            case PLUS:
                return left + right;
            case MINUS:
                return left - right;
            case MULTIPLY:
                return left * right;
            case DIVIDE:
                return left / right;
            default:
                throw new IllegalArgumentException("Unknown operator: " + this);
        }
    }
}
