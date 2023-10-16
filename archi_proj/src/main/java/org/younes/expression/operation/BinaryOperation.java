package org.younes.expression.operation;

import org.younes.expression.operator.BinaryOperator;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public abstract class BinaryOperation implements Operation {
    
    private final Operation left;
    private final Operation right;
    private final BinaryOperator operator;

    @JsonCreator
    public BinaryOperation(@JsonProperty("left") Operation left, @JsonProperty("right")Operation right, @JsonProperty("operator")BinaryOperator operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public String toReversePolishNotation() {
        return left.toReversePolishNotation() + " " + right.toReversePolishNotation() + " " + operator.getSymbol();
    }

    public Operation getLeft(){ return left; }

    public Operation getRight(){ return right; }

    public BinaryOperator getOperator(){ return operator; }
}
