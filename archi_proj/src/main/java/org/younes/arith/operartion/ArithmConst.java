package org.younes.arith.operartion;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ArithmConst implements ArithmOperation{

    private final Double value;

    @JsonCreator
    public ArithmConst(@JsonProperty("value") Double value) {
        this.value = value;
    }

    @Override
    public String toReversePolishNotation() {
        return String.valueOf(value);
    }

    public Double getValue() {
        return value;
    }

    @Override
    public double calculate() {
        return value;
    }

}
