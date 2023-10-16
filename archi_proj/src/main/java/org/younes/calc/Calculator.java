package org.younes.calc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.younes.arith.ArithmExpression;
import org.younes.data.SerializationFacade;
import org.younes.function.FunctionExpression;

public class Calculator {

    private final SerializationFacade serializationFacade;

    public Calculator(SerializationFacade serializationFacade) {
        this.serializationFacade = serializationFacade;
    }

    public String calculate(String filename, String value) {
        String content;

        try{
            content = readFile(filename);
        }catch (IOException e){
            throw new RuntimeException("The file does not exist");
        }


        try{

            FunctionExpression data = (FunctionExpression)serializationFacade.deserialize(content, FunctionExpression.class);

            if(value != null){
                data.setValue(Double.parseDouble(value));
            }

            return String.valueOf(data.calculate());

        }
        catch (Exception e) {
            try {

                ArithmExpression data = (ArithmExpression)serializationFacade.deserialize(content, ArithmExpression.class);

                return String.valueOf(data.calculate());

            } catch (Exception e1) {
                e1.printStackTrace();
                throw new RuntimeException("The file is not a valid Arithmetic Expression or Function Expression");
            }
        }
    }

    private String readFile(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
}
