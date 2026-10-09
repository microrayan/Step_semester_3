package oop.assigment_problems;

/**
 * F5. Capstone: A Small HR + Parking Allocation Mini-System
 * Demonstrates Object Composition (objects containing objects),
 * Static Counters, Encapsulation, and Null-Safe Formatting.
 */
class CompanyEmployeeRecord {
    public static int totalRecords = 0;

    private String name;
    private String empId;
    private Employee employee;
    private ParkingSlot slot;

    public CompanyEmployeeRecord(String name, String empId, Employee employee, ParkingSlot slot) {
        this.name = name;
        this.empId = empId;
        this.employee = employee;
        this.slot = slot;
        totalRecords++;
    }

    public double getEffectivePay() {
        if (employee instanceof ManagerEmployee) {
            return ((ManagerEmployee) employee).effectiveSalary();
        } else if (employee instanceof InternEmployee) {
            return ((InternEmployee) employee).effectiveSalary();
        } else if (employee != null) {
            return employee.getSalary();
        }
        return 0.0;
    }

    public String fullProfile() {
        double pay = getEffectivePay();
        String slotStr = (slot != null) ? slot.getSlotNo() : "no parking assigned";
        return String.format("%s | Pay: Rs %.1f | Slot: %s", name, pay, slotStr);
    }
}

public class CompanyHrParkingSystem {
    public static void main(String[] args) {
        System.out.println("=== F5: Capstone HR + Parking Allocation System ===");

        // Parking Slots
        ParkingSlot slotA1 = new ParkingSlot("A1", 4, 3);
        ParkingSlot slotA2 = new ParkingSlot("A2", 5, 4);

        // Employee objects
        ManagerEmployee divyaEmp = new ManagerEmployee("M101", "Divya", 70000.0, 8000.0);
        Employee karanEmp = new Employee("E102", "Karan", 40000.0);
        InternEmployee meeraEmp = new InternEmployee("I103", "Meera", 12000.0, 10000.0);

        // Allot parking to 2 employees, leaving 3rd unallotted
        slotA1.allot("TN09DIV123");
        slotA2.allot("TN09KAR456");

        // Create CompanyEmployeeRecord objects combining Employee + ParkingSlot
        CompanyEmployeeRecord rec1 = new CompanyEmployeeRecord("Divya", "M101", divyaEmp, slotA1);
        CompanyEmployeeRecord rec2 = new CompanyEmployeeRecord("Karan", "E102", karanEmp, slotA2);
        CompanyEmployeeRecord rec3 = new CompanyEmployeeRecord("Meera", "I103", meeraEmp, null);

        System.out.println(rec1.fullProfile());
        System.out.println(rec2.fullProfile());
        System.out.println(rec3.fullProfile());
        System.out.println("Total records: " + CompanyEmployeeRecord.totalRecords);
    }
}
