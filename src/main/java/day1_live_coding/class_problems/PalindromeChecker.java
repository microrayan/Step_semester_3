package day1_live_coding.class_problems;

public class PalindromeChecker {

    // Approach 1: Iterative Comparison
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = clean.length() - 1;
        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Approach 2: Recursive Check
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return checkRecursiveHelper(clean, 0, clean.length() - 1);
    }

    private static boolean checkRecursiveHelper(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return checkRecursiveHelper(str, start + 1, end - 1);
    }

    // Approach 3: Array Reversal Check
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] original = clean.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        return java.util.Arrays.equals(original, reversed);
    }

    public static void testInput(String input) {
        boolean iterative = isPalindromeIterative(input);
        boolean recursive = isPalindromeRecursive(input);
        boolean arrayRev = isPalindromeArrayReversal(input);

        String iterRes = iterative ? "Palindrome" : "Not Palindrome";
        String recRes = recursive ? "Palindrome" : "Not Palindrome";
        String arrRes = arrayRev ? "Palindrome" : "Not Palindrome";

        System.out.printf("Input: \"%s\"%n", input);
        System.out.printf("Iterative: %s | Recursive: %s | Array Reversal: %s%n%n", iterRes, recRes, arrRes);
    }

    public static void main(String[] args) {
        System.out.println("=== QA Text Verification Toolkit — Palindrome Checker ===");
        testInput("madam");
        testInput("hello");
        testInput("A man, a plan, a canal: Panama");
    }
}
