package com.stackroute;
import java.io.*;
public class FileMigration {
    public static String fileContentDuplicator(String stringOne, String stringTwo) throws IOException {
        String result =" ";
        //migrates content from one file to another file
        try {
            File fileNameOne = new File("/home/ubuntu/Desktop/file handling/text.txt/" + stringOne);
            File fileNameTwo = new File("/home/ubuntu/Desktop/file handling/textBackup.txt/" + stringTwo);
            FileInputStream fileInputStream = new FileInputStream(fileNameOne);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            FileOutputStream fileOutput = new FileOutputStream(fileNameTwo);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutput);
            int i;
            if (fileNameOne.length() != 0) {
                while (( i = fileInputStream.read()) != -1)
                    fileOutput.write(i);
            }
            //displays given file name is empty or null or contains blank space
            else {
                result ="Given filename to read or write is empty,null or blank space";
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter first file name");
        String fileNameOne = reader.readLine();
        System.out.println("Enter second file name");
        String fileNameTwo = reader.readLine();
        String result = fileContentDuplicator(fileNameOne, fileNameTwo);
        System.out.println(result);
    }
}

