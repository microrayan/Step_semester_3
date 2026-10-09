package day1_live_coding.class_problems;

public class BmiCalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            System.out.println("Invalid input data.");
            return;
        }

        System.out.println("==================== Corporate Wellness Program — BMI Report ====================");
        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-15s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("---------------------------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double height = heights[i];
            double weight = weights[i];
            double bmi = (height > 0) ? (weight / (height * height)) : 0.0;
            String status = getBmiStatus(bmi);

            System.out.printf("Person %-3d | %-12.2f | %-12.2f | %-8.2f | %-15s%n",
                    (i + 1), height, weight, bmi, status);
        }
        System.out.println("---------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        double[] heights = {1.75, 1.60, 1.80, 1.65, 1.70, 1.55, 1.85, 1.68, 1.72, 1.58};
        double[] weights = {70.0, 90.0, 68.0, 52.0, 78.0, 85.0, 95.0, 62.0, 110.0, 48.0};

        printWellnessReport(heights, weights);
    }
}
