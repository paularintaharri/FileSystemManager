package main.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogHandler {
    File file = new File("../out/log.txt");

    //Writes comment to the log.txt file
    public void logWriter(String text, long exTime){
        //current time
        LocalDateTime localDateTime = LocalDateTime.now();
        try {
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter bf = new BufferedWriter(fr);
            PrintWriter printWriter = new PrintWriter(bf);
            printWriter.print(localDateTime.format(DateTimeFormatter.ofPattern("dd-MMM-uuuu HH:mm:ss")) +": " + 
                text + ". The function took "+ exTime + " ms to execute\n");
            printWriter.close();
            bf.close();
            fr.close();            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Writes the error message to the log.txt file
    public void errorWriter(){
        LocalDateTime localDateTime = LocalDateTime.now();
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(localDateTime.format(DateTimeFormatter.ofPattern("dd-MMM-uuuu HH:mm:ss")) + "ERROR!\n");
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}