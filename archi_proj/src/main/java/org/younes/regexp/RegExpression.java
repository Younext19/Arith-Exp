package org.younes.regexp;

import org.younes.expression.Expression;
import org.younes.regexp.operation.RegexpOperation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RegExpression extends Expression {
    public static final String SYMBOL = "rational";

    @JsonCreator
    public RegExpression(@JsonProperty("operation") RegexpOperation operation) {
        super(operation);
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }

    public boolean nullable() {
        return ((RegexpOperation) getOperation()).nullable();
    }
}
