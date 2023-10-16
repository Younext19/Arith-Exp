package org.younes.regexp.operator;

import org.younes.expression.operator.UnaryOperator;

public enum RegexpUnaryOperator implements UnaryOperator {
    KLEENE_STAR("*");

    private final String symbol;

    RegexpUnaryOperator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static RegexpUnaryOperator fromSymbol(String symbol) {
        for (RegexpUnaryOperator operator : RegexpUnaryOperator.values()) {
            if (operator.getSymbol().equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("Unknown operator: " + symbol);
    }

    public static boolean isRegexpUnaryOperator(String symbol) {
        for (RegexpUnaryOperator operator : RegexpUnaryOperator.values()) {
            if (operator.getSymbol().equals(symbol)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOperator(String input) {
        for (RegexpUnaryOperator operator : RegexpUnaryOperator.values()) {
            if (operator.getSymbol().equals(input)) {
                return true;
            }
        }
        return false;
    }
}
