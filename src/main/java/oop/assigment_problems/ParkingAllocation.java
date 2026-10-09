package oop.assigment_problems;

/**
 * F3. Object References, Null Safety, and a Mutating Method
 *
 * Explanation of Object References:
 * In Java, when arrays of objects (like ParkingSlot[]) are passed into methods,
 * the method receives a copy of the reference to the array and its object references,
 * NOT a deep copy of the slot objects themselves. Thus, mutations performed via methods
 * like allot() directly modify the state of the underlying objects in memory.
 */
class ParkingSlot {
    private String slotNo;
    private int capacity;
    private int occupiedCount;

    public ParkingSlot(String slotNo, int capacity, int occupiedCount) {
        this.slotNo = slotNo;
        this.capacity = capacity;
        this.occupiedCount = occupiedCount;
    }

    public String getSlotNo() {
        return slotNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getOccupiedCount() {
        return occupiedCount;
    }

    public boolean isAvailable() {
        return occupiedCount < capacity;
    }

    public boolean allot(String vehicleNo) {
        if (isAvailable()) {
            occupiedCount++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s (%d/%d)", slotNo, occupiedCount, capacity);
    }
}

public class ParkingAllocation {

    public static ParkingSlot findAvailableSlot(ParkingSlot[] slots) {
        if (slots == null) return null;
        for (ParkingSlot slot : slots) {
            if (slot != null && slot.isAvailable()) {
                return slot;
            }
        }
        return null;
    }

    public static void safeAllot(ParkingSlot[] slots, String vehicleNo) {
        ParkingSlot available = findAvailableSlot(slots);
        if (available != null) {
            available.allot(vehicleNo);
            System.out.printf("%s allotted to slot %s%n", vehicleNo, available.getSlotNo());
        } else {
            System.out.printf("No slots available for %s%n", vehicleNo);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== F3: Object References and Null Safety ===");

        // Scenario 1: Slots with space available (A1 3/4, A2 5/5)
        ParkingSlot[] slotsWithSpace = new ParkingSlot[] {
            new ParkingSlot("A1", 4, 3),
            new ParkingSlot("A2", 5, 5)
        };

        System.out.print("Slots: ");
        System.out.printf("%s, %s%n", slotsWithSpace[0], slotsWithSpace[1]);
        safeAllot(slotsWithSpace, "TN09AB1234");

        System.out.println();

        // Scenario 2: All slots full (A1 4/4, A2 5/5)
        ParkingSlot[] fullSlots = new ParkingSlot[] {
            new ParkingSlot("A1", 4, 4),
            new ParkingSlot("A2", 5, 5)
        };

        System.out.print("Slots: ");
        System.out.printf("%s, %s%n", fullSlots[0], fullSlots[1]);
        safeAllot(fullSlots, "TN09AB1234");
    }
}
