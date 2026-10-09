package day2_live_coding.assigment_problems;

public class LibraryIsbnValidator {

    public static String normalizeCode(String raw) {
        if (raw == null) return null;
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed;
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code == null) {
            return "Invalid: code is null";
        }

        String normalized = normalizeCode(code);

        if (normalized.length() != 13) {
            return "Invalid: wrong code length (must be 13 characters)";
        }

        // Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(normalized.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Validate remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(normalized.charAt(i))) {
                return "Invalid: body must contain 10 digits";
            }
        }

        String pubCode = normalized.substring(0, 3);
        String year = normalized.substring(3, 7);
        String catalog = normalized.substring(7, 13);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] YEAR: ").append(year)
          .append(" | CATALOG: ").append(catalog);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Library ISBN Normalizer & Validator ===");
        System.out.println("Input: \" pen2026004251 \" -> " + validateAndFormat(" pen2026004251 "));
        System.out.println("Input: \"12N2026004251\" -> " + validateAndFormat("12N2026004251"));
    }
}
