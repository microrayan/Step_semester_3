package day2_live_coding.class_problems;

public class BankReferenceValidator {

    public static String normalizeReference(String raw) {
        if (raw == null) return null;
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed;
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference == null) {
            return "Invalid: reference is null";
        }

        String normalized = normalizeReference(reference);

        if (normalized.length() != 14) {
            return "Invalid: wrong reference length (must be 14 characters)";
        }

        // Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(normalized.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Validate remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(normalized.charAt(i))) {
                return "Invalid: remaining 11 characters must be digits";
            }
        }

        String bankCode = normalized.substring(0, 3);
        String day = normalized.substring(3, 5);
        String month = normalized.substring(5, 7);
        String year = normalized.substring(7, 9);
        String seq = normalized.substring(9, 14);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] DATE: ")
          .append(day).append("/").append(month).append("/").append(year)
          .append(" | SEQ: ").append(seq);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Bank Transaction Reference Generator & Validator ===");
        System.out.println("Input: \" hdf03022600042 \" -> " + validateAndFormat(" hdf03022600042 "));
        System.out.println("Input: \"12F03022600042\" -> " + validateAndFormat("12F03022600042"));
        System.out.println("Input: \"sbi15082600123\" -> " + validateAndFormat("sbi15082600123"));
    }
}
