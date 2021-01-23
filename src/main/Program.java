import java.util.InputMismatchException;
import java.util.Scanner;

import main.java.*;

public class Program {

  // Main program
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    InputHandler inputHandler = new InputHandler();
    FileManger fileManager = new FileManger();

    // Main menu
    int choice = inputHandler.getMainChoice(scanner);
    do {
      try {
        switch (choice) {
          case 1:
            fileManager.listAllFiles();
            break;
          case 2:
            fileManager.filesByExtension();
            break;
          case 3:
            fileManager.manipulateFile();
            break;
          case 4:
            System.out.println("Exit program");
            scanner.close();
            System.exit(0);
            break;
          default:
            System.out.println("Invalid option. Choose again please!");
            break;
        }
        choice = inputHandler.getMainChoice(scanner);
      }
      catch (NumberFormatException ex) {
        System.out.println("Please enter a number!");
        continue;
      }
    } while (choice != 4);
  }
}