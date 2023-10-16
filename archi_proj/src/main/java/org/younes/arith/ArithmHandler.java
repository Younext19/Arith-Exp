package org.younes.arith;

import org.younes.arith.operartion.ArithmBinaryExpressionBuilder;
import org.younes.arith.operartion.ArithmOperationFactory;
import org.younes.arith.operartion.ArithmUnaryExpressionBuilder;
import org.younes.arith.operator.ArithmBinaryOperator;
import org.younes.arith.operator.ArithmUnaryOperator;
import org.younes.expression.Expression;
import org.younes.editor.ExpressionComposite;
import org.younes.expression.InputHandler;

public class ArithmHandler implements InputHandler {
    @Override
    public boolean canHandle(String input) {
        if (ArithmBinaryOperator.isOperator(input) || ArithmUnaryOperator.isOperator(input)) {
            try {
                Double.parseDouble(input);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }

    @Override
    public void handle(String input, ExpressionComposite composite) throws IllegalArgumentException{
        if (ArithmBinaryOperator.isOperator(input)) {
            handleBinaryOperator(input, composite);
        } else if (ArithmUnaryOperator.isOperator(input)) {
            handleUnaryOperator(input, composite);
        } else {
            handleConst(input, composite);
        }
    }
    
    private void handleBinaryOperator(String input, ExpressionComposite composite) throws IllegalArgumentException{
        ArithmBinaryOperator operator = ArithmBinaryOperator.fromSymbol(input);

        Expression right = composite.pop();
        if (right == null) {
            throw new IllegalArgumentException("Missing operand for operator: " + input);
        }
        if (!(right instanceof ArithmExpression)) {
            composite.push(right);
            throw new IllegalArgumentException("Invalid operand for operator: " + input);
        }
        
        Expression left = composite.pop();
        if (left == null) {
            composite.push(right);
            throw new IllegalArgumentException("Missing operand for operator: " + input);
        }
        if (!(left instanceof ArithmExpression)) {
            composite.push(right);
            throw new IllegalArgumentException("Invalid operand for operator: " + input);
        }
        
        ArithmBinaryExpressionBuilder builder = new ArithmBinaryExpressionBuilder();
        builder.setOperator(operator);
        builder.setRight((ArithmExpression) right);
        builder.setLeft((ArithmExpression) left);
        
        composite.push(builder.build());
    }

    private void handleUnaryOperator(String input, ExpressionComposite composite) throws IllegalArgumentException {
        ArithmUnaryOperator operator = ArithmUnaryOperator.fromSymbol(input);

        Expression operand = composite.pop();
        if (operand == null) {
            throw new IllegalArgumentException("Missing operand for operator: " + input);
        }
        if (!(operand instanceof ArithmExpression)) {
            throw new IllegalArgumentException("Invalid operand for operator: " + input);
        }
        
        ArithmUnaryExpressionBuilder builder = new ArithmUnaryExpressionBuilder();
        builder.setOperator(operator);
        builder.setOperand(operand);
        
        composite.push(builder.build());
    }

    private void handleConst(String input, ExpressionComposite composite) throws IllegalArgumentException {
        try {
            double value = Double.parseDouble(input);
            composite.push(new ArithmExpression(ArithmOperationFactory.createConstOperation(value)));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid operand: " + input);
        }

    }
}
