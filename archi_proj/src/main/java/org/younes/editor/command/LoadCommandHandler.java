package org.younes.editor.command;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.younes.editor.EditorContext;
import org.younes.data.SerializationFacade;
import org.younes.expression.Expression;

public class LoadCommandHandler implements CommandHandler {
    private final SerializationFacade serializationFacade;

    public LoadCommandHandler(SerializationFacade serializationFacade) {
        this.serializationFacade = serializationFacade;
    }

    @Override
    public boolean canHandle(String input) {
        return input.startsWith("!load");
    }

    @Override
    public void execute(String input, EditorContext context) {
        String[] parts = input.split(" ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid input: " + input);
        }
        String fileName = parts[1];

        String fileContent = null;
        try {
            //read file content
            fileContent = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (Exception e) {
            throw new RuntimeException("Error loading file: " + fileName, e);
        }
        
        Object data = serializationFacade.deserialize(fileContent, context.getComposite().peek().getClass());
        
        context.getComposite().push((Expression) data);
    }
}
