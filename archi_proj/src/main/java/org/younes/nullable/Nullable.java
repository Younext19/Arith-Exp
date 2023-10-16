package org.younes.nullable;

import org.younes.data.SerializationFacade;
import org.younes.data.XmlSerializer;


public class Nullable {
    
    public static void main(String[] args) {

        // Hard coded :))
       args = new String[] { "src/main/resources/regex.xml" };
        if (args.length != 1) {
            System.out.println("Usage: java nullable <filename>");
            System.exit(1);
        }

        String fileName = args[0];

        SerializationFacade serializationFacade = new SerializationFacade(new XmlSerializer());
        NullableFacade nullableFacade = new NullableFacade(serializationFacade);

        try {
            String fileContent = nullableFacade.load(fileName);

            System.out.println(nullableFacade.evaluate(fileContent));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
