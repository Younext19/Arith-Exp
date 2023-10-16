package org.younes.regexp.operation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class RegexpConst implements RegexpOperation {

    private final String value;

    @JsonCreator
    public RegexpConst(@JsonProperty("value") String value) {
        this.value = value;
    }

    @Override
    public String toReversePolishNotation() {
        return String.valueOf(value);
    }

    @Override
    public boolean nullable() {
        return value.equals("1");
    }
}
