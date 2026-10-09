package day1_live_coding.assigment_problems;

public class TypingAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input strings.");
            return;
        }

        int minLen = Math.min(original.length(), typed.length());
        int totalChars = original.length();
        int matched = 0;
        int firstMismatchPos = -1;
        char origChar = '\0', typedChar = '\0';

        for (int i = 0; i < minLen; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else {
                if (firstMismatchPos == -1) {
                    firstMismatchPos = i + 1; // 1-indexed position
                    origChar = original.charAt(i);
                    typedChar = typed.charAt(i);
                }
            }
        }

        if (firstMismatchPos == -1 && typed.length() != original.length()) {
            firstMismatchPos = minLen + 1;
            origChar = (original.length() > minLen) ? original.charAt(minLen) : ' ';
            typedChar = (typed.length() > minLen) ? typed.charAt(minLen) : ' ';
        }

        double accuracy = (totalChars > 0) ? ((double) matched / totalChars) * 100.0 : 0.0;

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Matched: %d/%d | Accuracy: %.2f%% | ", matched, totalChars, accuracy));

        if (firstMismatchPos != -1) {
            sb.append(String.format("First Mismatch at position %d ('%c' vs '%c')", firstMismatchPos, origChar, typedChar));
        } else {
            sb.append("No Mismatches");
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println("=== Typing Speed Test Accuracy Checker ===");
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
