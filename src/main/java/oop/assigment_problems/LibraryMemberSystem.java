package oop.assigment_problems;

/**
 * F4. Designing the Instance/Static Boundary for a Library Membership System
 *
 * Why marking name, memberId, and booksIssued static was wrong:
 * Static fields are shared across ALL instances of a class. Marking instance-specific data
 * (like member name or ID) static causes every new object instantiation to overwrite the shared
 * variable, obliterating previous member data. Fields representing unique entity state MUST be instance fields.
 */

// Broken Version (for reproduction demonstration)
class BrokenLibraryMember {
    static String name;
    static String memberId;
    static int booksIssued;

    public BrokenLibraryMember(String name, String memberId, int booksIssued) {
        BrokenLibraryMember.name = name;
        BrokenLibraryMember.memberId = memberId;
        BrokenLibraryMember.booksIssued = booksIssued;
    }

    public void printName() {
        System.out.println(name);
    }
}

// Corrected Redesign Version
class LibraryMember {
    // Static class-wide metadata
    private static String libraryName = "Central Campus Library";
    private static int memberCount = 0;

    // Instance-specific state
    private String name;
    private String memberId;
    private int booksIssued;

    public LibraryMember(String name, int booksIssued) {
        memberCount++;
        this.name = name;
        this.memberId = "LM-" + (1000 + memberCount);
        this.booksIssued = booksIssued;
    }

    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }

    public void printMemberCard() {
        System.out.printf("%s | %s%n", name, memberId);
    }

    public static void printTotalMembers() {
        System.out.println("Total members: " + memberCount);
    }
}

public class LibraryMemberSystem {
    public static void main(String[] args) {
        System.out.println("=== F4: Instance vs Static Design Boundary ===");

        System.out.println("--- Broken Version Demonstration ---");
        BrokenLibraryMember m1 = new BrokenLibraryMember("Aditi", "LM-1001", 2);
        BrokenLibraryMember m2 = new BrokenLibraryMember("Rohan", "LM-1002", 1);
        m1.printName();
        m2.printName();

        System.out.println("\n--- Fixed Version Demonstration ---");
        LibraryMember fixed1 = new LibraryMember("Aditi", 2);
        LibraryMember fixed2 = new LibraryMember("Rohan", 1);

        fixed1.printMemberCard();
        fixed2.printMemberCard();
        LibraryMember.printTotalMembers();
    }
}
