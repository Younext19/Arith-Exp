package org.younes.arith.operartion;

import org.younes.arith.operator.ArithmBinaryOperator;
import org.younes.arith.operator.ArithmUnaryOperator;

public class ArithmOperationFactory {

    public static ArithmOperation createConstOperation(Double value) {
        return new ArithmConst(value);
    }

    public static ArithmOperation createUnaryOperation(ArithmOperation operation, ArithmUnaryOperator operator) {
        return new ArithmUnaryOperation(operation, operator);
    }

    public static ArithmOperation createBinaryOperation(ArithmOperation left, ArithmOperation right, ArithmBinaryOperator operator) {
        return new ArithmBinaryOperation(left, right, operator);
    }
}