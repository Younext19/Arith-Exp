package org.younes.regexp.operation;

import org.younes.expression.operation.UnaryOperation;

import org.younes.regexp.operator.RegexpUnaryOperator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RegexpUnaryOperation extends UnaryOperation implements RegexpOperation {
    
    @JsonCreator
    public RegexpUnaryOperation(@JsonProperty("operation") RegexpOperation operation, @JsonProperty("operator") RegexpUnaryOperator operator) {
        super(operation, operator);
    }

    @Override
    public boolean nullable() {
        return ((RegexpOperation) getOperation()).nullable();
    }
}
