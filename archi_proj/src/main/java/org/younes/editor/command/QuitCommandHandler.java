package org.younes.editor.command;

import org.younes.editor.EditorContext;

public class QuitCommandHandler implements CommandHandler {
    @Override
    public boolean canHandle(String input) {
        return input.startsWith("!quit");
    }

    @Override
    public void execute(String input, EditorContext context) {
        //System.exit(0);
    }
}
