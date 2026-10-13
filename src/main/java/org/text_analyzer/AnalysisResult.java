package org.text_analyzer;

import java.util.List;
import java.util.Map;

public record AnalysisResult(
        int totalWords,
        int uniqueWords,
        Map<String, Integer> wordCounts,
        List<Map.Entry<String, Integer>> topWords
) {
}
