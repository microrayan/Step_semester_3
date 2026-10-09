package string.class_problems;

public class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = cleanStr.length() - 1;
        while (left < right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String test = "A man, a plan, a canal: Panama";
        System.out.println("Is Palindrome: " + isPalindrome(test));
    }
}
