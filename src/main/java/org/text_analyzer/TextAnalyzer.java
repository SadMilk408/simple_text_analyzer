package org.text_analyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextAnalyzer {
    static String readText(Path path) throws IOException {
        return Files.readString(path);
    }

    static List<String> splitIntoWords(String text) {
        return List.of(
                text.toLowerCase()
                        .replaceAll("[^a-zA-Z0-9\\s]", "")
                        .split("\\s+")
        );
    }

    static Map<String, Integer> countWords(List<String> words) {
        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : words) {
            wordCounts.merge(word, 1, Integer::sum);
        }

        return wordCounts;
    }
}
