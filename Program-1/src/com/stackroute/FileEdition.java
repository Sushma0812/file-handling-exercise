package com.stackroute;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;
public class FileEdition {
    public static String fileEditor(String stringOne, String stringTwo) throws IOException {
        //append the string to a text file
        try {
            File fileName = new File("/home/ubuntu/Desktop/java/File-Handling/Program-1/text.txt" + stringOne);
            if (stringTwo.isEmpty() == false && fileName.exists() && !stringOne.isEmpty() && stringOne != " ") {
                FileOutputStream fileOut = new FileOutputStream(stringOne, true);
                byte[] byteArray = stringTwo.getBytes();
                fileOut.write(byteArray);
                FileInputStream fileInputStream = new FileInputStream(stringOne);
                int character;
                while ((character = fileInputStream.read()) != -1) {
                    System.out.print((char) character);
                }
            }
            //if file not found displays file not exist
            else {
                System.out.println("File" + "'" + stringOne + "'" + "does not exist");
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a file name");
        String fileName = reader.readLine();
        System.out.println("Enter a string");
        String string = reader.readLine();
        fileEditor(fileName, string);
    }
}
