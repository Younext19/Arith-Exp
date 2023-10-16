package org.younes.expression;

import org.younes.expression.operator.Operator;

public abstract class BinaryExpressionBuilder<O extends Operator, T extends Expression> implements ExpressionBuilder {

    protected T left;
    protected T right;
    protected O operator;

    public void setLeft(T left) {
        this.left = left;
    }

    public void setRight(T right) {
        this.right = right;
    }

    public void setOperator(O operator) {
        this.operator = operator;
    }
}