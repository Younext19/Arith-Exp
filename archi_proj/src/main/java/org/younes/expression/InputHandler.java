package org.younes.expression;

import org.younes.editor.ExpressionComposite;

public interface InputHandler {

    boolean canHandle(String input);

    void handle(String input, ExpressionComposite composite) throws IllegalArgumentException;

}
