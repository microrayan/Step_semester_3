package day1_live_coding.class_problems;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();

        for (char ch : text.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch : text.toCharArray()) {
            if (frequencyMap.get(ch) == 1) {
                return ch;
            }
        }

        return '\0';
    }

    public static void processInput(String text) {
        char result = findFirstNonRepeatingChar(text);
        System.out.printf("Input: \"%s\" -> ", text);
        if (result != '\0') {
            System.out.printf("First Non-Repeating Character: '%c'%n", result);
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Unique Letter Hunt Mini-Game ===");
        processInput("swiss");
        processInput("aabbcc");
        processInput("leetcode");
        processInput("stress");
    }
}
