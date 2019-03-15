package com.latewind.test.java8;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class FileTest {

    @Test
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

    @Test
    public void testReadFile() {
        Path path = Paths.get("log4j.log");

        try {
            String content = new String(Files.readAllBytes(path));
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReadFileStream() throws IOException {
        //Read file line by line – Java 8 Stream
        Stream<String> lines = Files.lines(Paths.get("log4j.log"));
        Optional<String> optional = lines.filter(s -> s.contains("ZooKeeper")).findFirst();

        if(optional.isPresent()){
            System.out.println(optional.get());
        }
        lines.close();
    }
}
