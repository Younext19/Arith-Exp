package org.younes.arith.operartion;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.younes.arith.operator.ArithmBinaryOperator;
import org.younes.expression.operation.BinaryOperation;

public class ArithmBinaryOperation extends BinaryOperation implements ArithmOperation{
    @JsonCreator
    public ArithmBinaryOperation(@JsonProperty("left") ArithmOperation left, @JsonProperty("right") ArithmOperation right, @JsonProperty("operator") ArithmBinaryOperator operator) {
        super(left, right, operator);
    }

    @Override
    public double calculate() {
        return ((ArithmBinaryOperator)getOperator()).apply(((ArithmOperation)getLeft()).calculate(), ((ArithmOperation)getRight()).calculate());
    }
}
