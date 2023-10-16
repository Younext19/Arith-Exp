package org.younes.arith.operator;

import org.younes.expression.operator.UnaryOperator;

public enum ArithmUnaryOperator implements UnaryOperator {
    NEGATION("+");

    private final String symbol;

    ArithmUnaryOperator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static ArithmUnaryOperator fromSymbol(String symbol) {
        for (ArithmUnaryOperator operator : ArithmUnaryOperator.values()) {
            if (operator.getSymbol().equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("Unknown operator: " + symbol);
    }

    public static boolean isArithmUnaryOperator(String symbol) {
        for (ArithmUnaryOperator operator : ArithmUnaryOperator.values()) {
            if (operator.getSymbol().equals(symbol)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOperator(String input) {
        for (ArithmUnaryOperator operator : ArithmUnaryOperator.values()) {
            if (operator.getSymbol().equals(input)) {
                return true;
            }
        }
        return false;
    }

    public double apply(double operand) {
        switch (this) {
            case NEGATION:
                return -operand;
            default:
                throw new IllegalArgumentException("Unknown operator: " + this);
        }
    }
}
