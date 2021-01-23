package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileManger {
    String path = "../src/main/resources/";
    File folder = new File(path);
    File[] fileList = folder.listFiles();
    Scanner scanner = new Scanner(System.in);
    InputHandler inputHandler = new InputHandler();
    FileManipulator fileManipulator = new FileManipulator();

    //Makes a list of all files in the folder
    public void listAllFiles() {
        if (fileList.length == 0){
            System.out.println("Files not found");
        }else {
            for (int i = 0; i < fileList.length; i++) {
                if (fileList[i].isFile()) {
                    System.out.println(fileList[i].getName());
                } else if (fileList[i].isDirectory()) {
                    System.out.println("Directory " + fileList[i].getName());
                }
            }
        }
    }

    //Makes a list of a files with sertain extension
    public void filesByExtension() {
        System.out.println("Enter a file-extension: ");
        String input = scanner.nextLine();
        int count = 0;

        for (File f : folder.listFiles()) {
            String fileName = f.getName();
            String fileExtension = fileName.substring(fileName.indexOf(".") + 1, f.getName().length());
            fileExtension = fileExtension.toLowerCase();
            if (fileExtension.equals(input)) {
                System.out.println(f.getName());
                count++;
            }
        }
        if (count == 0){
            System.out.println("Files not found with " + input + "-extension");
        }
    }
    
    //Asks what file user wants to manipulate
    public void manipulateFile() {
            System.out.println("List of files that you can manipulate\n");
            listAllFiles();      
            System.out.println("\nEnter the file name you want to manipulate:\n");
            String input = scanner.nextLine();
            String newpath = path + input;
            manipulateFileMenu(newpath);       
    }

    //File manipulation options menu
    public void manipulateFileMenu(String newpath) {
        int choice = inputHandler.getManipulateChoice(scanner);
        try (BufferedReader br = new BufferedReader(new FileReader(newpath))) {
            do {
                switch (choice) {
                    case 1:
                        fileManipulator.getName(newpath);
                        break;
                    case 2:
                        fileManipulator.getSize(newpath);
                        break;
                    case 3:
                        fileManipulator.getLineCount(newpath);
                        break;
                    case 4:
                        fileManipulator.searchWord(newpath);
                        break;
                    case 5:
                        fileManipulator.countWord(newpath);
                        break;
                    case 6:
                        scanner.close();
                        break;
                    default:
                        System.out.println("Invalid option. Choose again please!");
                }
                choice = inputHandler.getManipulateChoice(scanner);
            } while (choice != 6);
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found.\n"+e.getMessage());
        } catch (IOException e) {
            System.out.println("Error while reading the file.\n"+e.getMessage());
        }   
    }
}