package org.younes.function.operation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.younes.expression.operation.BinaryOperation;
import org.younes.function.operator.FunctionBinaryOperator;

public class FunctionBinaryOperation extends BinaryOperation implements FunctionOperation {

    @JsonIgnore
    private double value;

    @JsonCreator
    public FunctionBinaryOperation(@JsonProperty("left") FunctionOperation left, @JsonProperty("right") FunctionOperation right, @JsonProperty("operator") FunctionBinaryOperator operator) {
        super(left, right, operator);
    }

    @Override
    public double calculate() {
        FunctionBinaryOperator operator = (FunctionBinaryOperator) getOperator();

        FunctionOperation left = (FunctionOperation) getLeft();
        FunctionOperation right = (FunctionOperation) getRight();

        left.setValue(value);
        double leftValue = left.calculate();
        
        right.setValue(value);
        double rightValue = right.calculate();

        return operator.apply(leftValue, rightValue);
    }

    @Override
    public void setValue(double value) {
        this.value = value;
    }
}
