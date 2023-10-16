package org.younes.function.operator;

import org.younes.expression.operator.BinaryOperator;

public enum FunctionBinaryOperator implements BinaryOperator{
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;

    FunctionBinaryOperator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static FunctionBinaryOperator fromSymbol(String symbol) {
        for (FunctionBinaryOperator operator : FunctionBinaryOperator.values()) {
            if (operator.getSymbol().equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("Unknown operator: " + symbol);
    }

    public static boolean isFunctionOperator(String symbol) {
        for (FunctionBinaryOperator operator : FunctionBinaryOperator.values()) {
            if (operator.getSymbol().equals(symbol)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOperator(String input) {
        for (FunctionBinaryOperator operator : FunctionBinaryOperator.values()) {
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
