package main.java;

import java.util.Scanner;

public class InputHandler{
    
    public Integer getMainChoice(Scanner scanner) {
        //Content of the main menu
         System.out.println("-------------------------\n");
         System.out.println("Choose from these options");
         System.out.println("-------------------------\n");
         System.out.println("1 - List all available files");
         System.out.println("2 - List files by extension");
         System.out.println("3 - Manipulate .txt file");
         System.out.println("4 - Quit");
         System.out.println("-------------------------\n");
         return Integer.parseInt(scanner.nextLine());
     }

     public Integer getManipulateChoice(Scanner scanner) {
        //Content of the Manipulate menu
        System.out.println("-------------------------\n");
        System.out.println("Choose from these options");
        System.out.println("-------------------------\n");
        System.out.println("-- 1 - Get the name of the file");
        System.out.println("-- 2 - Size of the file");
        System.out.println("-- 3 - How many lines is in the file");
        System.out.println("-- 4 - Search a specific word from the file");
        System.out.println("-- 5 - How many times a specific word is found in the file");
        System.out.println("-- 6 - Quit");
        System.out.println("-------------------------\n");
        return Integer.parseInt(scanner.nextLine());
    }
}