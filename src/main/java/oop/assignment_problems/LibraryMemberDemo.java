package oop.assignment_problems;

// ---------------------------------------------------------
// BROKEN VERSION
// ---------------------------------------------------------

class BrokenLibraryMember {

    // These are WRONG as static because every object shares
    // the same copy of these variables.
    //
    // name:
    // Each member should have their own name, but static makes
    // all members share one name.
    //
    // memberId:
    // Each member should have their own unique ID, but static
    // makes every member share the same ID.
    //
    // booksIssued:
    // Each member can have a different number of books, but
    // static makes them all share the same book count.

    static String name;
    static String memberId;
    static int booksIssued;

    BrokenLibraryMember(String name, String memberId, int booksIssued) {
        BrokenLibraryMember.name = name;
        BrokenLibraryMember.memberId = memberId;
        BrokenLibraryMember.booksIssued = booksIssued;
    }
}

// ---------------------------------------------------------
// CORRECTED VERSION
// ---------------------------------------------------------

class LibraryMember {

    // Instance fields
    // Each LibraryMember object gets its own copy.
    String name;
    String memberId;
    int booksIssued;

    // Static fields
    // These belong to the LibraryMember class as a whole.
    static String libraryName = "SRM Library";
    static int memberCount = 0;

    // Constructor
    LibraryMember(String name, int booksIssued) {

        this.name = name;
        this.booksIssued = booksIssued;

        memberCount++;

        // Automatically generate member ID
        this.memberId = "LM-" + (1000 + memberCount);
    }

    // Instance method
    void printMemberCard() {

        System.out.println(
                name + " | " + memberId +
                        " | Books issued: " + booksIssued);
    }

    // Static method
    static void printTotalMembers() {

        System.out.println("Total members: " + memberCount);
    }
}

// ---------------------------------------------------------
// MAIN CLASS
// ---------------------------------------------------------

public class LibraryMemberDemo {

    public static void main(String[] args) {

        // =================================================
        // BROKEN VERSION
        // =================================================

        System.out.println("Broken version:");

        BrokenLibraryMember member1 = new BrokenLibraryMember("Aditi", "LM-1001", 2);

        BrokenLibraryMember member2 = new BrokenLibraryMember("Rohan", "LM-1002", 3);

        // Because all fields are static, member2 overwrites
        // the shared data that member1 was using.

        System.out.println(member1.name);
        System.out.println(member2.name);

        System.out.println(
                "(Aditi's data was overwritten — both members now show Rohan)");

        System.out.println();

        // =================================================
        // FIXED VERSION
        // =================================================

        System.out.println("Fixed version:");

        LibraryMember fixedMember1 = new LibraryMember("Aditi", 2);

        LibraryMember fixedMember2 = new LibraryMember("Rohan", 3);

        fixedMember1.printMemberCard();
        fixedMember2.printMemberCard();

        LibraryMember.printTotalMembers();
    }
}