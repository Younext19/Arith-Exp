package org.younes.function.operation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class FunctionVariable implements FunctionOperation {
    private final String name;

    @JsonIgnore
    private Double value;

    @JsonCreator
    public FunctionVariable(@JsonProperty("value") String name) {
        this.name = name;
    }

    @Override
    public String toReversePolishNotation() {
        return name;
    }

    @Override
    public double calculate() {
        if (value == null) {
            throw new IllegalStateException("Value of variable " + name + " is not set");
        }
        return value;
    }

    @Override
    public void setValue(double value) {
        this.value = value;
    }
}
