package org.younes.function.operation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.younes.expression.operation.UnaryOperation;
import org.younes.function.operator.FunctionUnaryOperator;

public class FunctionUnaryOperation extends UnaryOperation implements FunctionOperation {
    
    @JsonIgnore
    private double value;

    @JsonCreator
    public FunctionUnaryOperation(@JsonProperty("operation") FunctionOperation operation, @JsonProperty("operator") FunctionUnaryOperator operator) {
        super(operation, operator);
    }

    @Override
    public double calculate() {
        FunctionUnaryOperator operator = (FunctionUnaryOperator) getOperator();

        FunctionOperation operation = (FunctionOperation) getOperation();

        operation.setValue(value);
        double operationValue = operation.calculate();

        return operator.apply(operationValue);
    }

    @Override
    public void setValue(double value) {
        this.value = value;
    }
}
