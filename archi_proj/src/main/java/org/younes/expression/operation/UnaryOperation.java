package org.younes.expression.operation;

import org.younes.expression.operator.UnaryOperator;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public abstract class UnaryOperation implements Operation {
    
    private final Operation operation;
    private final UnaryOperator operator;

    @JsonCreator
    protected UnaryOperation(@JsonProperty("operation") Operation operation, @JsonProperty("operator") UnaryOperator operator) {
        this.operation = operation;
        this.operator = operator;
    }

    @Override
    public String toReversePolishNotation() {
        return operation.toReversePolishNotation() + " " + operator.getSymbol();
    }

    public Operation getOperation() {
        return operation;
    }

    public UnaryOperator getOperator() {
        return operator;
    }
}
