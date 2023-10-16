package org.younes.expression;

import org.younes.expression.operator.Operator;

public abstract class UnaryExpressionBuilder<O extends Operator, T extends Expression> implements ExpressionBuilder {

    protected Expression operand;
    protected O operator;

    public UnaryExpressionBuilder<O, T> setOperand(Expression operand) {
        this.operand = operand;
        return this;
    }

    public UnaryExpressionBuilder<O, T> setOperator(O operator) {
        this.operator = operator;
        return this;
    }
}
