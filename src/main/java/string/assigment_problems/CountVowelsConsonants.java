package string.assigment_problems;

public class CountVowelsConsonants {
    public static void countVowelsAndConsonants(String str) {
        if (str == null) return;
        int vowels = 0, consonants = 0;
        String lower = str.toLowerCase();
        for (int i = 0; i < lower.length(); i++) {
            char ch = lower.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if ("aeiou".indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);
    }

    public static void main(String[] args) {
        countVowelsAndConsonants("Hello World");
    }
}
