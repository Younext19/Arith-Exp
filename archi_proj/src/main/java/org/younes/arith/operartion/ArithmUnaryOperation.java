package org.younes.arith.operartion;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.younes.arith.operator.ArithmUnaryOperator;
import org.younes.expression.operation.UnaryOperation;

public class ArithmUnaryOperation extends UnaryOperation implements ArithmOperation {

    @JsonCreator
    public ArithmUnaryOperation(@JsonProperty("operation") ArithmOperation operation, @JsonProperty("operator") ArithmUnaryOperator operator) {
        super(operation, operator);
    }

    @Override
    public double calculate() {
        return ((ArithmUnaryOperator)getOperator()).apply(((ArithmOperation)getOperation()).calculate());
    }
}
