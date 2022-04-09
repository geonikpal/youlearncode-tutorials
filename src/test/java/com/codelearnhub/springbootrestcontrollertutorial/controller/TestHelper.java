package com.codelearnhub.springbootrestcontrollertutorial.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestHelper {

    public static String readFile(String fileName){
        try {
            return Files.readAllLines(Paths.get("src/test/resources" + fileName))
                    .stream()
                    .reduce(String::concat)
                    .orElse("");
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
