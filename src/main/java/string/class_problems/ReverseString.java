package string.class_problems;

public class ReverseString {
    public static String reverse(String str) {
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        String original = "hello";
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reverse(original));
    }
}
