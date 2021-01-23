package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class FileManipulator {

    LogHandler logger = new LogHandler();

    // Gets the name of the file
    public void getName(String path) {
        long startTime = System.currentTimeMillis();
        File file = new File(path);
        String filename = file.getName();
        String result = "The name of the file is: " + filename;
        System.out.println(result);
        long endTime = System.currentTimeMillis();
        logger.logWriter(result, endTime-startTime);
    }

    // Gets the size of the file
    public void getSize(String path) {
        long startTime = System.currentTimeMillis();
        File file = new File(path);
        if (!file.exists() || !file.isFile())
            return;
        Double fileSize = (double) (file.length() / 1024); //counts the size
        String result = "The size of the file is: " + fileSize + " kb.";
        System.out.println(result);
        long endTime = System.currentTimeMillis();
        logger.logWriter(result, endTime-startTime);
    }

    // Counts how many line is on the file
    public void getLineCount(String path) {
        try {
            long startTime = System.currentTimeMillis();
            LineNumberReader reader = new LineNumberReader(new FileReader(path));
            int count = 0;
            String lineRead = "";

            while ((lineRead = reader.readLine()) != null);
                count = reader.getLineNumber();
                reader.close();
                String result = "File includes " + count + " lines";
                System.out.println(result);
                reader.close();
                long endTime = System.currentTimeMillis();
                logger.logWriter(result, endTime-startTime);

        } catch (FileNotFoundException e) {
            System.out.println("The file was not found.\n"+e.getMessage());
            logger.errorWriter();
        } catch (IOException e) {
            System.out.println("Error while reading the file.\n"+e.getMessage());
            logger.errorWriter();      
        } catch (NumberFormatException ex) {
            System.out.println("Please enter a number!");
          }
    }

    //Search if the specific word exists on the file
    public void searchWord(String path){

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            long startTime = System.currentTimeMillis();
            Scanner scanner = new Scanner(System.in);
            boolean check = false;
            String word;
            String result = "";

            System.out.println("Write the word what you want to serch");
            String input = scanner.nextLine();

            //reads the file untill the word is found
            while((word = br.readLine()) != null){                
                if(word.toLowerCase().contains(input.toLowerCase())) { 
                    check = true;
                }
            }
            if(check) {
                result = "Word was found";
                System.out.println(result);
            } else if (!check) {
                result = "Word was not found";
                System.out.println(result);    
            }     
            long endTime = System.currentTimeMillis();
            logger.logWriter(result, endTime-startTime);
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found.\n"+e.getMessage());
            logger.errorWriter();
        } catch (IOException e) {
            System.out.println("Error while reading the file.\n"+e.getMessage());
            logger.errorWriter();      
        }  
    }

    //Count how many times a word exists on the fiel
    public void countWord(String path){
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            long startTime = System.currentTimeMillis();
            Scanner scanner = new Scanner(System.in);
            boolean check = false;
            int count = 0;
            String word;
            String result = "";

            System.out.println("Write the word what you want to count");
            String input = scanner.nextLine();

            //loops the file and counts the words
            while((word = br.readLine()) != null){                
                if(word.toLowerCase().contains(input.toLowerCase())) { 
                    count++;
                }
            }
            if(count > 0) {
                result = "Word was found " + count + " times";
                System.out.println(result);
            } else if (count == 0) {
                result = "Word was not found";
                System.out.println(result);    
            }  
            long endTime = System.currentTimeMillis();
            logger.logWriter(result, endTime-startTime);   
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found.\n"+e.getMessage());
            logger.errorWriter();
        } catch (IOException e) {
            System.out.println("Error while reading the file.\n"+e.getMessage());
            logger.errorWriter();      
        } 
    }

}