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

    static AnalysisResult analyze(String text) {
        List<String> words = TextAnalyzer.splitIntoWords(text);

        Map<String, Integer> wordsCount = TextAnalyzer.countWords(words);

        List<Map.Entry<String, Integer>> topWords = TextAnalyzer.getTopWords(wordsCount, 2);

        return new AnalysisResult(words.size(), wordsCount.size(), wordsCount, topWords);
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

    static List<Map.Entry<String, Integer>> getTopWords(
            Map<String, Integer> wordCounts,
            int limit
    ) {
        return wordCounts
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(limit)
                .toList();
    }

    static void printResult(AnalysisResult result) {
        System.out.println("Total words: " + result.totalWords());
        System.out.println("Unique words: " + result.uniqueWords());

        System.out.println("Top words:");
        for (Map.Entry<String, Integer> entry : result.topWords()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
