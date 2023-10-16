package org.younes.function.operation;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class FunctionConst implements FunctionOperation {
    private final Double value;

    @JsonCreator
    public FunctionConst(@JsonProperty("value") Double value) {
        this.value = value;
    }

    @Override
    public String toReversePolishNotation() {
        return String.valueOf(value);
    }

    @Override
    public double calculate() {
        return value;
    }

    @Override
    public void setValue(double value) {
        // nothing to do here
    }
}
