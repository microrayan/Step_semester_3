package oop.assigment_problems;

/**
 * F1. From Procedural Mess to a Working Library Fine System
 *
 * Justification for Static vs Instance Methods:
 * - fineAmount() is an INSTANCE method because the fine calculation depends strictly
 *   on the specific instance's state (daysOverdue of a particular book).
 * - totalFineCollected() is a STATIC method because it operates across an array/collection
 *   of BookIssue objects. It belongs to the BookIssue class concept as a whole rather than
 *   any single individual book instance.
 */
public class BookIssue {
    private String title;
    private String borrowerName;
    private int daysOverdue;

    public BookIssue(String title, String borrowerName, int daysOverdue) {
        this.title = title;
        this.borrowerName = borrowerName;
        this.daysOverdue = daysOverdue;
    }

    public String getTitle() {
        return title;
    }

    public int getDaysOverdue() {
        return daysOverdue;
    }

    public double fineAmount() {
        if (daysOverdue > 0) {
            return daysOverdue * 5.0; // Rs 5 per day
        }
        return 0.0;
    }

    public boolean isSeverelyOverdue() {
        return daysOverdue > 14;
    }

    public static double totalFineCollected(BookIssue[] issues) {
        if (issues == null) return 0.0;
        double total = 0.0;
        for (BookIssue issue : issues) {
            if (issue != null) {
                total += issue.fineAmount();
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("=== F1: Working Library Fine System ===");

        BookIssue[] books = new BookIssue[] {
            new BookIssue("Clean Code", "Student 1", 18),
            new BookIssue("Effective Java", "Student 2", 5),
            new BookIssue("Refactoring", "Student 3", 0),
            new BookIssue("DSA Handbook", "Student 4", 21),
            new BookIssue("Design Patterns", "Student 5", 9)
        };

        for (BookIssue b : books) {
            String status = b.isSeverelyOverdue() ? "Severely overdue" : "OK";
            System.out.printf("%s - %d days - %s%n", b.getTitle(), b.getDaysOverdue(), status);
        }

        double totalFine = BookIssue.totalFineCollected(books);
        System.out.printf("Total fine collected: Rs %.1f%n", totalFine);
    }
}
