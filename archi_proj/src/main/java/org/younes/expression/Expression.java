package org.younes.expression;

import org.younes.expression.operation.Operation;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class Expression {

    private Operation operation;

    public Expression(){}

    protected Expression(Operation operation) {
        this.operation = operation;
    }

    @JsonIgnore
    public abstract String getSymbol();

    public String toReversePolishNotation(){
        return operation.toReversePolishNotation();
    }

    public Operation getOperation() {
        return operation;
    }

}
