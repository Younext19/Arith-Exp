package org.younes.function.operation;

import org.younes.expression.Expression;
import org.younes.expression.UnaryExpressionBuilder;
import org.younes.function.FunctionExpression;
import org.younes.function.FunctionExpressionBuilder;
import org.younes.function.operator.FunctionUnaryOperator;

public class FunctionUnaryExpressionBuilder extends UnaryExpressionBuilder<FunctionUnaryOperator, FunctionExpression> implements FunctionExpressionBuilder {

    @Override
    public Expression build() throws IllegalStateException{
        if (operand == null) {
            throw new IllegalStateException("operand expression must be set");
        }

        return new FunctionExpression(FunctionOperationFactory.createUnaryOperation((FunctionOperation)operand.getOperation(), operator));
    }
}
