package org.younes.regexp;

import org.younes.editor.ExpressionComposite;
import org.younes.expression.Expression;
import org.younes.expression.InputHandler;
import org.younes.regexp.operation.RegexpBinaryExpressionBuilder;
import org.younes.regexp.operation.RegexpOperationFactory;
import org.younes.regexp.operation.RegexpUnaryExpressionBuilder;
import org.younes.regexp.operator.RegexpBinaryOperator;
import org.younes.regexp.operator.RegexpUnaryOperator;

public class RegexpHandler implements InputHandler {
    @Override
    public boolean canHandle(String input) {
        return input.matches("[a-z]{1,20}") 
                || input.equals("1") 
                || RegexpBinaryOperator.isOperator(input) 
                || RegexpUnaryOperator.isOperator(input);
    }

    @Override
    public void handle(String input, ExpressionComposite composite) throws IllegalArgumentException{
        if (input.matches("[a-z]{1,20}") || input.equals("1")) {
            handleConst(input, composite);
        } else if (RegexpBinaryOperator.isOperator(input)) {
            handleBinaryOperator(input, composite);
        } else if (RegexpUnaryOperator.isOperator(input)) {
            handleUnaryOperator(input, composite);
        }else {
            throw new IllegalArgumentException("Invalid input: " + input);
        }
    }

    private void handleUnaryOperator(String input, ExpressionComposite composite) throws IllegalArgumentException {
        RegexpUnaryOperator operator = RegexpUnaryOperator.fromSymbol(input);

        Expression operand = composite.pop();
        if (operand == null) {
            throw new IllegalArgumentException("Missing operand for operator: " + input);
        }
        if (!(operand instanceof RegExpression)) {
            composite.push(operand);
            throw new IllegalArgumentException("Invalid operand for operator: " + input);
        }

        RegexpUnaryExpressionBuilder builder = new RegexpUnaryExpressionBuilder();
        builder.setOperator(operator);
        builder.setOperand((RegExpression) operand);

        composite.push(builder.build());

    }

    private void handleBinaryOperator(String input, ExpressionComposite composite) throws IllegalArgumentException {
        RegexpBinaryOperator operator = RegexpBinaryOperator.fromSymbol(input);

        Expression right = composite.pop();
        if (right == null) {
            throw new IllegalArgumentException("Missing operand for operator: " + input);
        }
        if (!(right instanceof RegExpression)) {
            composite.push(right);
            throw new IllegalArgumentException("Invalid operand for operator: " + input);
        }

        Expression left = composite.pop();
        if (left == null) {
            composite.push(right);
            throw new IllegalArgumentException("Missing operand for operator: " + input);
        }
        if (!(left instanceof RegExpression)) {
            composite.push(right);
            throw new IllegalArgumentException("Invalid operand for operator: " + input);
        }

        RegexpBinaryExpressionBuilder builder = new RegexpBinaryExpressionBuilder();
        builder.setOperator(operator);
        builder.setRight((RegExpression) right);
        builder.setLeft((RegExpression) left);

        composite.push(builder.build());
    }

    private void handleConst(String input, ExpressionComposite composite) throws IllegalArgumentException {
        composite.push(new RegExpression(RegexpOperationFactory.createConstOperation(input)));
    }
}
 