package day2_live_coding.class_problems;

public class FileExtensionValidator {

    public static String validateFileExtension(String filename) {
        if (filename == null || filename.isEmpty()) {
            return "Rejected — invalid file type";
        }

        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String ext = filename.substring(lastDotIndex + 1);

        if (ext.equalsIgnoreCase("pdf") || ext.equalsIgnoreCase("docx") || ext.equalsIgnoreCase("zip")) {
            return "Accepted";
        } else {
            return "Rejected — invalid file type";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== File Extension Validator ===");
        System.out.println("Input: \"Assignment1.PDF\" -> " + validateFileExtension("Assignment1.PDF"));
        System.out.println("Input: \"notes.txt\" -> " + validateFileExtension("notes.txt"));
        System.out.println("Input: \"project_archive.ZIP\" -> " + validateFileExtension("project_archive.ZIP"));
    }
}
