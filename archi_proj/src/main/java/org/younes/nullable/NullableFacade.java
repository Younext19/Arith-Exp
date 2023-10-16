package org.younes.nullable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.younes.data.SerializationFacade;
import org.younes.regexp.RegExpression;

public class NullableFacade {

    private final SerializationFacade serializationFacade;

    public NullableFacade(SerializationFacade serializationFacade) {
        this.serializationFacade = serializationFacade;
    }

    public String load(String fileName) {
        try{
            return readFile(fileName);
        }catch (IOException e){
            throw new RuntimeException("The file does not exist");
        }
    }

    public String evaluate(String fileContent) {
        try{

            RegExpression data = (RegExpression)serializationFacade.deserialize(fileContent, RegExpression.class);

            return data.nullable() ? "TRUE" : "fake";

        }catch (RuntimeException e){
            throw new RuntimeException("The file is not a valid Regular Expression");
        }
        catch (Exception e1){ 
            throw new RuntimeException("Please, check the file");
        
        }
    }


    private String readFile(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }

}
