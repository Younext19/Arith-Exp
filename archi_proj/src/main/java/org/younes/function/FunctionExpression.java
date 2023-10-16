package org.younes.function;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.younes.arith.ArithmExpression;
import org.younes.function.operation.FunctionOperation;

public class FunctionExpression extends ArithmExpression {

    public static final String SYMBOL = "function";
    private double value;

    @JsonCreator
    public FunctionExpression(@JsonProperty("operation") FunctionOperation operation) {
        super(operation);
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @JsonIgnore
    public double getValue() {
        return value;
    }

    @Override
    public double calculate() {
        FunctionOperation operation = (FunctionOperation) getOperation();
        operation.setValue(value);

        return operation.calculate();
    }
}
