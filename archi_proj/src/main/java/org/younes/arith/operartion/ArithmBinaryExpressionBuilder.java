package org.younes.arith.operartion;

import org.younes.arith.ArithmExpression;
import org.younes.arith.ArithmExpressionBuilder;
import org.younes.arith.operator.ArithmBinaryOperator;
import org.younes.expression.BinaryExpressionBuilder;
import org.younes.expression.Expression;

public class ArithmBinaryExpressionBuilder extends BinaryExpressionBuilder<ArithmBinaryOperator, ArithmExpression> implements ArithmExpressionBuilder {

    @Override
    public Expression build() {
        if (left == null || right == null) {
            throw new IllegalStateException("Left and right expressions must be set");
        }

        return new ArithmExpression(ArithmOperationFactory.createBinaryOperation((ArithmOperation)left.getOperation(), (ArithmOperation)right.getOperation(), operator));
    }
}
