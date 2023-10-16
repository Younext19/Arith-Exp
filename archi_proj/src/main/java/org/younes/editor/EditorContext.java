package org.younes.editor;

import org.younes.arith.ArithmHandler;
import org.younes.editor.command.CommandHandler;
import org.younes.editor.command.LoadCommandHandler;
import org.younes.editor.command.QuitCommandHandler;
import org.younes.editor.command.SaveCommandHandler;
import org.younes.editor.command.TypeCommandHandler;
import org.younes.data.SerializationFacade;
import org.younes.data.XmlSerializer;
import org.younes.expression.ExpressionType;
import org.younes.expression.InputHandler;
import org.younes.function.FunctionHandler;
import org.younes.regexp.RegexpHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditorContext {

    private final Map<ExpressionType, InputHandler> handlers = new HashMap<>();
    private final List<CommandHandler> commandHandlers = new ArrayList<>();
    private ExpressionType currentType;
    private final ExpressionComposite composite = new ExpressionComposite();
    private final SerializationFacade serializationFacade;

    // Add all handlers at once
    public EditorContext() {

        serializationFacade = new SerializationFacade(new XmlSerializer());

        handlers.put(ExpressionType.ARITHM, new ArithmHandler());
        handlers.put(ExpressionType.FUNCTION, new FunctionHandler());
        handlers.put(ExpressionType.REGEXP, new RegexpHandler());

        commandHandlers.add(new LoadCommandHandler(serializationFacade));
        commandHandlers.add(new SaveCommandHandler(serializationFacade));
        commandHandlers.add(new QuitCommandHandler());
        commandHandlers.add(new TypeCommandHandler());

        currentType = ExpressionType.ARITHM;
    }
    
    private InputHandler getHandler(ExpressionType type) {
        return handlers.get(type);
    }

    // Function to get the input handler
    public InputHandler getCurrentInputHandler() {
        return getHandler(currentType);
    }

    // Function to get the command handler
    public CommandHandler getCommandHandler(String input) {
        for (CommandHandler commandHandler : commandHandlers) {
            if (commandHandler.canHandle(input)) {
                return commandHandler;
            }
        }
        return null;
    }

    public void print() {
        composite.print();
    }
    
    public void setCurrentType(ExpressionType type) {
        this.currentType = type;
    }

    public ExpressionComposite getComposite() {
        return composite;
    }

    public boolean handleInput(String input)  throws IllegalArgumentException{
        if (input.startsWith("!")) {
            CommandHandler handler = getCommandHandler(input);
            if (handler != null) {
                handler.execute(input, this);

                if (handler instanceof QuitCommandHandler) {
                    return true;
                }

            } else {
                System.out.println("Invalid command.");
            }
        } else {
            InputHandler handler = getCurrentInputHandler();
            if (handler != null) {
                handler.handle(input, composite);
            } else {
                System.out.println("Invalid input.");
            }
        }

        return false;
    }
}
