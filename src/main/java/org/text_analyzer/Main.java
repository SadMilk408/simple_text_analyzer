package org.text_analyzer;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path filePath = Path.of("data", "words.txt");
        String text = "";

        try {
            text = TextAnalyzer.readText(filePath);
        } catch (IOException e) {
            System.out.println("File doesn't exist");
        }

        List<String> words = TextAnalyzer.splitIntoWords(text);

        System.out.print(TextAnalyzer.countWords(words));
    }
}