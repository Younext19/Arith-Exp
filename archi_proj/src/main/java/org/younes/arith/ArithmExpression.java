package org.younes.arith;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.younes.arith.operartion.ArithmOperation;
import org.younes.expression.Expression;

public class ArithmExpression extends Expression {

    public static  String SYMBOL = "arith";

    @JsonCreator
    public ArithmExpression(@JsonProperty("operation") ArithmOperation operation) {
        super(operation);
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }

    public double calculate(){
        return ((ArithmOperation)getOperation()).calculate();
    }


}
