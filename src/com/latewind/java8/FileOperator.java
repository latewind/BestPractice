package com.latewind.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperator {

    public void testFile() {
        Path filePath = Paths.get("test.txt");
        if (!Files.exists(filePath)) {
            try {
                Files.createFile(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readFile(){
        Path path = Paths.get("log4j.log");

        try {
           String content =  new String(Files.readAllBytes(path));
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
        FileOperator oper = new FileOperator();
        oper.testFile();
        oper.readFile();
    }
}
