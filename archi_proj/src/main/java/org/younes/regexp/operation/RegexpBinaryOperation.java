package org.younes.regexp.operation;

import org.younes.expression.operation.BinaryOperation;
import org.younes.regexp.operator.RegexpBinaryOperator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RegexpBinaryOperation extends BinaryOperation implements RegexpOperation {
    
    @JsonCreator
    public RegexpBinaryOperation(@JsonProperty("left") RegexpOperation left, @JsonProperty("right") RegexpOperation right, @JsonProperty("operator") RegexpBinaryOperator operator) {
        super(left, right, operator);
    }

    @Override
    public boolean nullable() {
        return ((RegexpOperation) getLeft()).nullable() || ((RegexpOperation) getRight()).nullable();
    }
}
