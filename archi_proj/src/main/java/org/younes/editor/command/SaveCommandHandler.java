package org.younes.editor.command;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.younes.editor.EditorContext;
import org.younes.data.SerializationFacade;

public class SaveCommandHandler implements CommandHandler {
    private final SerializationFacade serializationFacade;

    public SaveCommandHandler(SerializationFacade serializationFacade) {
        this.serializationFacade = serializationFacade;
    }
    
    @Override
    public boolean canHandle(String input) {
        return input.startsWith("!save");
    }

    @Override   
    public void execute(String input, EditorContext context) {
        // !save <filename> : file may contain spaces escaped with \, so we need to split by space taking into account the \ character
        String[] parts = input.split("(?<!\\\\) ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid input: " + input);
        }
        String fileName = parts[1];
        
        String fileContent = serializationFacade.serialize(context.getComposite().peek().getClass().cast(context.getComposite().peek()));

        try {
            //write file content
            Files.write(Paths.get(fileName), fileContent.getBytes());
        } catch (Exception e) {
            throw new RuntimeException("Error saving file: " + fileName, e);
        }
    }
}
