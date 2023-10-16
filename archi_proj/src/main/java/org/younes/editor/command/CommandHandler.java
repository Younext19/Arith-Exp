package org.younes.editor.command;

import org.younes.editor.EditorContext;

public interface CommandHandler {
    boolean canHandle(String input);
    
    void execute(String input, EditorContext context);
}
