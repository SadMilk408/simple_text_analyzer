package org.text_analyzer;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Path filePath = Path.of("data", "words.txt");
        String text = "";

        try {
            text = TextAnalyzer.readText(filePath);
        } catch (IOException e) {
            System.out.println("File doesn't exist");
            return;
        }

        List<String> words = TextAnalyzer.splitIntoWords(text);

        Map<String, Integer> wordsCount = TextAnalyzer.countWords(words);

        System.out.print(TextAnalyzer.getTopWords(wordsCount, 2));
    }
}