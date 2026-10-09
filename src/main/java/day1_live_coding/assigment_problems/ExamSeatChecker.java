package day1_live_coding.assigment_problems;

public class ExamSeatChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("No seats provided.");
            return;
        }

        boolean foundDuplicate = false;
        boolean[] printed = new boolean[seatNumbers.length];

        for (int i = 0; i < seatNumbers.length; i++) {
            if (printed[i]) continue;
            boolean isDup = false;
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    isDup = true;
                    printed[j] = true;
                }
            }
            if (isDup) {
                foundDuplicate = true;
                System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
            }
        }

        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Exam Hall Seat Duplication Checker ===");

        int[] sample1 = {101, 102, 103, 102, 105};
        System.out.print("Input: ");
        printArray(sample1);
        checkDuplicateSeats(sample1);

        System.out.println();

        int[] sample2 = {101, 102, 103, 104, 105};
        System.out.print("Input: ");
        printArray(sample2);
        checkDuplicateSeats(sample2);
    }

    private static void printArray(int[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println("}");
    }
}
