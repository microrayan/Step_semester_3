package day1_live_coding.class_problems;

public class ReverseCustomerName {

    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }

        char[] charArray = customerName.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }

        return new String(charArray);
    }

    public static void main(String[] args) {
        System.out.println("=== Customer Identity Verification System ===");
        String name1 = "Sunil";
        System.out.println("Original Name: " + name1);
        System.out.println("Reversed Name: " + reverseCustomerName(name1));

        System.out.println();
        String name2 = "Alexander";
        System.out.println("Original Name: " + name2);
        System.out.println("Reversed Name: " + reverseCustomerName(name2));
    }
}
