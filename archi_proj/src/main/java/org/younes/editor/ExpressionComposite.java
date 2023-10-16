package org.younes.editor;

import org.younes.expression.Expression;
import org.younes.expression.IExpression;

import java.util.Stack;

public class ExpressionComposite implements IExpression {
    private final Stack<Expression> expressions = new Stack<>();


    public void push(Expression expression) {
        expressions.push(expression);
    }

    public Expression pop() {
        return expressions.pop();
    }

    public Expression peek() {
        return expressions.peek();
    }

    public boolean isEmpty() {
        return expressions.isEmpty();
    }

    public int size() {
        return expressions.size();
    }

    @Override
    public void print() {
        if (expressions.isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            for (int i = expressions.size() - 1; i >= 0; i--) {
                System.out.printf("%d: [%s] %s%n", i, expressions.get(expressions.size() - 1 - i).getSymbol(),
                        expressions.get(expressions.size() - 1 - i).toReversePolishNotation());
            }
        }
    }

}
