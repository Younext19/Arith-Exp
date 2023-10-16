package org.younes.expression;

public enum ExpressionType {
    ARITHM("arithm"),
    FUNCTION("function"),
    REGEXP("rational");

    private final String type;

    ExpressionType(String type) {
        this.type = type;
    }

    public static ExpressionType fromString(String type) {
        for (ExpressionType expressionType : ExpressionType.values()) {
            if (expressionType.type.equalsIgnoreCase(type)) {
                return expressionType;
            }
        }
        return null;
    }

    public String getType() {
        return type;
    }
}
