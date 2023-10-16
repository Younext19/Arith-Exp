package org.younes.regexp.operation;


import org.younes.regexp.operator.RegexpUnaryOperator;
import org.younes.regexp.operator.RegexpBinaryOperator;

public class RegexpOperationFactory {

    public static RegexpOperation createConstOperation(String value) {
        return new RegexpConst(value);
    }

    public static RegexpOperation createUnaryOperation(RegexpOperation operation, RegexpUnaryOperator operator) {
        return new RegexpUnaryOperation(operation, operator);
    }

    public static RegexpOperation createBinaryOperation(RegexpOperation left, RegexpOperation right,
            RegexpBinaryOperator operator) {
        return new RegexpBinaryOperation(left, right, operator);
    }
    
}