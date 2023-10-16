package org.younes.regexp.operation;

import org.younes.expression.BinaryExpressionBuilder;
import org.younes.expression.Expression;
import org.younes.regexp.RegExpression;
import org.younes.regexp.RegexpBuilder;
import org.younes.regexp.operator.RegexpBinaryOperator;

public class RegexpBinaryExpressionBuilder extends BinaryExpressionBuilder<RegexpBinaryOperator, RegExpression> implements RegexpBuilder {

    @Override
    public Expression build() {
        if (left == null || right == null) {
            throw new IllegalStateException("Left and right expressions must be set");
        }

        return new RegExpression(RegexpOperationFactory.createBinaryOperation((RegexpOperation)left.getOperation(), (RegexpOperation)right.getOperation(), operator));
    }
}
