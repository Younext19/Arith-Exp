package org.younes.regexp.operation;

import org.younes.expression.Expression;
import org.younes.expression.UnaryExpressionBuilder;
import org.younes.regexp.RegExpression;
import org.younes.regexp.RegexpBuilder;
import org.younes.regexp.operator.RegexpUnaryOperator;

public class RegexpUnaryExpressionBuilder extends UnaryExpressionBuilder<RegexpUnaryOperator, RegExpression> implements RegexpBuilder {

    @Override
    public Expression build() throws IllegalStateException{
        if (operand == null) {
            throw new IllegalStateException("operand expression must be set");
        }

        return new RegExpression(RegexpOperationFactory.createUnaryOperation((RegexpOperation)operand.getOperation(), operator));
    }
}
