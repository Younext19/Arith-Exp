package org.younes.editor.command;

import org.younes.editor.EditorContext;
import org.younes.expression.ExpressionType;

public class TypeCommandHandler implements CommandHandler {

    private static final String COMMAND = "!type";
        

    @Override
    public boolean canHandle(String input) {
        return input.startsWith(COMMAND);
    }

    @Override
    public void execute(String input, EditorContext context) {
        String[] tokens = input.split(" ");
        if (tokens.length != 2) {
            System.out.println("Invalid command");
            return;
        }

        String type = tokens[1];
        ExpressionType newType = ExpressionType.fromString(type);
        if (newType == null) {
            System.out.println("Invalid type");
            return;
        }

        System.out.println("Changing type to: " + newType.getType());

        context.setCurrentType(newType);
    }

}
