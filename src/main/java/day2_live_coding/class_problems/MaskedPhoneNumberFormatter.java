package day2_live_coding.class_problems;

public class MaskedPhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        String lastFour = phone.substring(6);
        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.insert(6, "-");
        sb.append(lastFour);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Masked Phone Number Formatter ===");
        System.out.println("Input: \"9876543210\" -> " + maskPhoneNumber("9876543210"));
        System.out.println("Input: \"98765\" -> " + maskPhoneNumber("98765"));
        System.out.println("Input: \"987654321a\" -> " + maskPhoneNumber("987654321a"));
    }
}
