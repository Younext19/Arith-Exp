package org.younes.arith.operartion;

import org.younes.arith.ArithmExpression;
import org.younes.arith.ArithmExpressionBuilder;
import org.younes.arith.operator.ArithmUnaryOperator;
import org.younes.expression.Expression;
import org.younes.expression.UnaryExpressionBuilder;

public class ArithmUnaryExpressionBuilder extends UnaryExpressionBuilder<ArithmUnaryOperator, ArithmExpression> implements ArithmExpressionBuilder {

    @Override
    public Expression build() {
        if (operand == null) {
            throw new IllegalStateException("operand expression must be set");
        }

        return new ArithmExpression(ArithmOperationFactory.createUnaryOperation((ArithmOperation)operand.getOperation(), operator));
    }
}
