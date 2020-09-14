package com.stackroute;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;
public class FileEdition {
    public static String fileEditor(String stringOne, String stringTwo) throws IOException {
        String result = " ";
        //append the string to a text file
        try {
            File fileName = new File("/home/ubuntu/Desktop/java/File-Handling/Program-1/text.txt" + stringOne);
            if (stringTwo.isEmpty() == false && fileName.exists() && !stringOne.isEmpty() && stringOne != " ") {
                FileOutputStream fileOutputStream = new FileOutputStream(stringOne, true);
                byte[] stringTwoBytes = stringTwo.getBytes();
                fileOutputStream.write(stringTwoBytes);
                FileInputStream fileInputStream = new FileInputStream(stringOne);
                int i;
                while ((i = fileInputStream.read()) != -1) {
                    System.out.print((char) i);
                }
            }
            //if file not found displays file not exist
            else {
                result = "File does not exist";
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a file name");
        String fileName = reader.readLine();
        System.out.println("Enter a string");
        String string = reader.readLine();
        String result = fileEditor(fileName, string);
        System.out.println(result);
    }
}
