package org.text_analyzer;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Path filePath = Path.of("data", "words.txt");

        try {
            String text = TextAnalyzer.readText(filePath);

            AnalysisResult result = TextAnalyzer.analyze(text);

            TextAnalyzer.printResult(result);
        } catch (IOException e) {
            System.out.println("File doesn't exist");
        }
    }
}