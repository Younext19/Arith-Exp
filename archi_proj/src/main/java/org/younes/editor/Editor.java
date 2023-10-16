package org.younes.editor;


import java.util.Scanner;

public class Editor {
    public static void main(String[] args) {

        ExpressionEditor editor = new ExpressionEditor();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            editor.print();
            try {
                System.out.print("> ");
                quit = editor.handleInput(scanner.nextLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        scanner.close();
    }
}
