package org.younes.function;

import org.younes.arith.ArithmHandler;
import org.younes.editor.ExpressionComposite;
import org.younes.expression.Expression;
import org.younes.function.operation.FunctionBinaryExpressionBuilder;
import org.younes.function.operation.FunctionOperationFactory;
import org.younes.function.operation.FunctionUnaryExpressionBuilder;
import org.younes.function.operator.FunctionBinaryOperator;
import org.younes.function.operator.FunctionUnaryOperator;

public class FunctionHandler extends ArithmHandler {

    @Override
    public boolean canHandle(String input) {
        return super.canHandle(input) || isVariable(input);
    }

    @Override
    public void handle(String input, ExpressionComposite composite) {
        if (isVariable(input)) {
            handleVariable(input, composite);
        } else if (FunctionBinaryOperator.isOperator(input)) {
            handleBinaryOperator(input, composite);
        } else if (FunctionUnaryOperator.isOperator(input)) {
            handleUnaryOperator(input, composite);
        } else {
            handleConst(input, composite);
        }
    }

    private void handleBinaryOperator(String input, ExpressionComposite composite) throws IllegalArgumentException{
        
        FunctionBinaryOperator operator = FunctionBinaryOperator.fromSymbol(input);

        Expression right = composite.pop();
        if (right == null) {
            throw new IllegalArgumentException("Missing operand for operator: " + input);
        }
        if (!(right instanceof FunctionExpression)) {
            composite.push(right);
            throw new IllegalArgumentException("Invalid operand for operator: " + input);
        }
        
        Expression left = composite.pop();
        if (left == null) {
            composite.push(right);
            throw new IllegalArgumentException("Missing operand for operator: " + input);
        }
        if (!(left instanceof FunctionExpression)) {
            composite.push(right);
            throw new IllegalArgumentException("Invalid operand for operator: " + input);
        }
        
        FunctionBinaryExpressionBuilder builder = new FunctionBinaryExpressionBuilder();
        builder.setOperator(operator);
        builder.setRight((FunctionExpression) right);
        builder.setLeft((FunctionExpression) left);
        
        composite.push(builder.build());
    }

    private void handleUnaryOperator(String input, ExpressionComposite composite) {
        FunctionUnaryOperator operator = FunctionUnaryOperator.fromSymbol(input);

        Expression operand = composite.pop();
        if (operand == null) {
            throw new IllegalArgumentException("Missing operand for operator: " + input);
        }
        if (!(operand instanceof FunctionExpression)) {
            composite.push(operand);
            throw new IllegalArgumentException("Invalid operand for operator: " + input);
        }

        FunctionUnaryExpressionBuilder builder = new FunctionUnaryExpressionBuilder();
        builder.setOperator(operator);
        builder.setOperand((FunctionExpression) operand);

        composite.push(builder.build());
    }

    private void handleConst(String input, ExpressionComposite composite) {
        try {
            double value = Double.parseDouble(input);
            composite.push(new FunctionExpression(FunctionOperationFactory.createConstOperation(value)));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input: " + input);
        }
    }

    private void handleVariable(String input, ExpressionComposite composite) {
        composite.push(new FunctionExpression(FunctionOperationFactory.createVariableOperation(input)));
    }

    public boolean isVariable(String input) {
        if (input.equals("x")) {
            return true;
        }
        return false;
    }
}