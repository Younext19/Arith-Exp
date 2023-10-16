package org.younes.regexp.operator;

import org.younes.expression.operator.BinaryOperator;

public enum RegexpBinaryOperator implements BinaryOperator{
    UNION("+"),
    CONCAT(".");

    private final String symbol;

    RegexpBinaryOperator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static RegexpBinaryOperator fromSymbol(String symbol) {
        for (RegexpBinaryOperator operator : RegexpBinaryOperator.values()) {
            if (operator.getSymbol().equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("Unknown operator: " + symbol);
    }

    public static boolean isFunctionOperator(String symbol) {
        for (RegexpBinaryOperator operator : RegexpBinaryOperator.values()) {
            if (operator.getSymbol().equals(symbol)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOperator(String input) {
        for (RegexpBinaryOperator operator : RegexpBinaryOperator.values()) {
            if (operator.getSymbol().equals(input)) {
                return true;
            }
        }
        return false;
    }
}
