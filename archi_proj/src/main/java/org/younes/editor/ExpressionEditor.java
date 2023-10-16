package org.younes.editor;

public class ExpressionEditor {

    private final EditorContext context;

    public ExpressionEditor() {
        context = new EditorContext();
    }

    public boolean handleInput(String input) {
        return context.handleInput(input);
    }

    public void print() {
        context.print();
    }
}
