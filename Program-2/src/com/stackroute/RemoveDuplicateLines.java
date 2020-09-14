package com.stackroute;

import java.util.*;
import java.io.FileInputStream;
import java.io.*;
public class RemoveDuplicateLines {
    //removes duplicate lines from input file and write into output file
    public static void removeDuplicateLines() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("input.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        Set<String> stringHashSet = new HashSet<String>(10000);
        String string;
        while ((string = bufferedReader.readLine()) != null) {
            stringHashSet.add(string);
        }
        bufferedReader.close();
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        for (String distinctStrings : stringHashSet) {
            bufferedWriter.write(distinctStrings);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
    public static void main(String args[]) throws IOException {
        removeDuplicateLines();
    }
}