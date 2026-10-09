package day2_live_coding.assigment_problems;

import java.util.*;

public class FilteredWordFrequencyReport {

    private static final Set<String> STOP_WORDS = new HashSet<>(
            Arrays.asList("the", "was", "and", "a", "is", "of", "in")
    );

    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            System.out.println("No feedback content provided.");
            return;
        }

        // Normalize: lowercase & strip punctuation (periods, commas, quotes)
        String cleaned = feedback.toLowerCase().replaceAll("[.,!?'\"]", "");
        String[] words = cleaned.trim().split("\\s+");

        Map<String, Integer> freqMap = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty() || STOP_WORDS.contains(word)) {
                continue;
            }
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Sort entry list by frequency descending
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(freqMap.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Stop-Word-Filtered Word Frequency Report ===");
        String sampleFeedback = "The mentor was great, the session was great and clear.";
        System.out.println("Input: \"" + sampleFeedback + "\"\nOutput:");
        printFilteredWordFrequency(sampleFeedback);
    }
}
