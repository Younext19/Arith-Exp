package org.younes.function.operation;

import org.younes.function.operator.FunctionUnaryOperator;
import org.younes.function.operator.FunctionBinaryOperator;

public class FunctionOperationFactory {

    public static FunctionOperation createConstOperation(Double value) {
        return new FunctionConst(value);
    }

    public static FunctionOperation createUnaryOperation(FunctionOperation operation, FunctionUnaryOperator operator) {
        return new FunctionUnaryOperation(operation, operator);
    }

    public static FunctionOperation createBinaryOperation(FunctionOperation left, FunctionOperation right,
            FunctionBinaryOperator operator) {
        return new FunctionBinaryOperation(left, right, operator);
    }
    
    public static FunctionOperation createVariableOperation(String name) {
        return new FunctionVariable(name);
    }
}