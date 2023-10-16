package org.younes.function.operator;

import org.younes.expression.operator.UnaryOperator;

public enum FunctionUnaryOperator implements UnaryOperator {
    NEGATION("+");

    private final String symbol;

    FunctionUnaryOperator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static FunctionUnaryOperator fromSymbol(String symbol) {
        for (FunctionUnaryOperator operator : FunctionUnaryOperator.values()) {
            if (operator.getSymbol().equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("Unknown operator: " + symbol);
    }

    public static boolean isFunctionUnaryOperator(String symbol) {
        for (FunctionUnaryOperator operator : FunctionUnaryOperator.values()) {
            if (operator.getSymbol().equals(symbol)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOperator(String input) {
        for (FunctionUnaryOperator operator : FunctionUnaryOperator.values()) {
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
