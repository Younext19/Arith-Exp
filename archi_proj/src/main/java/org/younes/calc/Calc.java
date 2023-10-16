package org.younes.calc;

import org.younes.data.SerializationFacade;
import org.younes.data.XmlSerializer;


public class Calc {
    
    public static void main(String[] args) {
         if (args.length < 1) {
             System.out.println("Usage: java calc filename [value]");
             System.exit(1);
         }

        String filename = args[0];
        String value = args.length > 1 ? args[1] : null;

        SerializationFacade serializationFacade = new SerializationFacade(new XmlSerializer());
        Calculator calculator = new Calculator(serializationFacade);

        try {
            System.out.println("The result: " + calculator.calculate(filename, value));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
    
}
