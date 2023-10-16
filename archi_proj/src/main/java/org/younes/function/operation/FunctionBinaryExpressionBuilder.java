package org.younes.function.operation;

import org.younes.expression.BinaryExpressionBuilder;
import org.younes.expression.Expression;
import org.younes.function.FunctionExpression;
import org.younes.function.operator.FunctionBinaryOperator;
import org.younes.function.FunctionExpressionBuilder;

public class FunctionBinaryExpressionBuilder extends BinaryExpressionBuilder<FunctionBinaryOperator, FunctionExpression> implements FunctionExpressionBuilder {

    @Override
    public Expression build() {
        if (left == null || right == null) {
            throw new IllegalStateException("Left and right expressions must be set");
        }

        return new FunctionExpression(FunctionOperationFactory.createBinaryOperation((FunctionOperation)left.getOperation(), (FunctionOperation)right.getOperation(), operator));
    }
}
