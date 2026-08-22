package oop.assignment_problems;

// ======================================================
// Employee
// ======================================================

class Employee {

    private String empId;
    private String empName;
    private double salary;

    Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    double getSalary() {
        return salary;
    }
}

// ======================================================
// ManagerEmployee
// ======================================================

class ManagerEmployee extends Employee {

    private double teamBonus;

    ManagerEmployee(String empId, String empName,
            double salary, double teamBonus) {

        super(empId, empName, salary);
        this.teamBonus = teamBonus;
    }

    double effectiveSalary() {
        return getSalary() + teamBonus;
    }
}

// ======================================================
// InternEmployee
// ======================================================

class InternEmployee extends Employee {

    private double stipendCap;

    InternEmployee(String empId, String empName,
            double salary, double stipendCap) {

        super(empId, empName, salary);
        this.stipendCap = stipendCap;
    }

    double effectiveSalary() {

        if (getSalary() < stipendCap) {
            return getSalary();
        } else {
            return stipendCap;
        }
    }
}

// ======================================================
// ParkingSlot
// ======================================================

class ParkingSlot {

    String slotNo;
    int capacity;
    int occupiedCount;

    ParkingSlot(String slotNo, int capacity, int occupiedCount) {
        this.slotNo = slotNo;
        this.capacity = capacity;
        this.occupiedCount = occupiedCount;
    }

    void allot(String vehicleNo) {

        if (occupiedCount < capacity) {
            occupiedCount++;
            System.out.println(
                    vehicleNo + " allotted to slot " + slotNo);
        }
    }

    static ParkingSlot findAvailableSlot(ParkingSlot[] slots) {

        for (ParkingSlot slot : slots) {

            if (slot.occupiedCount < slot.capacity) {
                return slot;
            }
        }

        return null;
    }

    static void safeAllot(ParkingSlot[] slots, String vehicleNo) {

        ParkingSlot availableSlot = findAvailableSlot(slots);

        if (availableSlot != null) {
            availableSlot.allot(vehicleNo);
        } else {
            System.out.println(
                    "No slots available for " + vehicleNo);
        }
    }
}

// ======================================================
// CompanyEmployeeRecord
// ======================================================

class CompanyEmployeeRecord {

    String name;
    String empId;

    // These fields themselves are objects.
    Employee employee;
    ParkingSlot slot;

    static int totalRecords = 0;

    CompanyEmployeeRecord(
            String name,
            String empId,
            Employee employee,
            ParkingSlot slot) {

        this.name = name;
        this.empId = empId;
        this.employee = employee;
        this.slot = slot;

        totalRecords++;
    }

    String fullProfile() {

        double effectivePay;

        // Manager has its own effective salary.
        if (employee instanceof ManagerEmployee) {

            ManagerEmployee manager = (ManagerEmployee) employee;

            effectivePay = manager.effectiveSalary();

            // Intern has its own effective salary.
        } else if (employee instanceof InternEmployee) {

            InternEmployee intern = (InternEmployee) employee;

            effectivePay = intern.effectiveSalary();

            // Plain Employee uses normal salary.
        } else {

            effectivePay = employee.getSalary();
        }

        String parkingInfo;

        if (slot != null) {
            parkingInfo = slot.slotNo;
        } else {
            parkingInfo = "no parking assigned";
        }

        return name
                + " | Pay: Rs "
                + effectivePay
                + " | Slot: "
                + parkingInfo;
    }
}

// ======================================================
// MAIN
// ======================================================

public class CompanyEmployeeRecordDemo {

    public static void main(String[] args) {

        // --------------------------------------------------
        // Create parking slots
        // --------------------------------------------------

        ParkingSlot[] parkingSlots = {
                new ParkingSlot("A1", 1, 0),
                new ParkingSlot("A2", 1, 0)
        };

        // --------------------------------------------------
        // Create employees
        // --------------------------------------------------

        ManagerEmployee divyaEmployee = new ManagerEmployee(
                "E101",
                "Divya",
                70000,
                8000);

        Employee karanEmployee = new Employee(
                "E102",
                "Karan",
                40000);

        InternEmployee meeraEmployee = new InternEmployee(
                "E103",
                "Meera",
                12000,
                10000);

        // --------------------------------------------------
        // Allot parking to ONLY two employees
        // --------------------------------------------------

        ParkingSlot.safeAllot(
                parkingSlots,
                "E101");

        ParkingSlot.safeAllot(
                parkingSlots,
                "E102");

        // No parking is allotted to Meera.

        // --------------------------------------------------
        // Create three CompanyEmployeeRecord objects
        // --------------------------------------------------

        CompanyEmployeeRecord record1 = new CompanyEmployeeRecord(
                "Divya",
                "E101",
                divyaEmployee,
                parkingSlots[0]);

        CompanyEmployeeRecord record2 = new CompanyEmployeeRecord(
                "Karan",
                "E102",
                karanEmployee,
                parkingSlots[1]);

        CompanyEmployeeRecord record3 = new CompanyEmployeeRecord(
                "Meera",
                "E103",
                meeraEmployee,
                null);

        // --------------------------------------------------
        // Print profiles
        // --------------------------------------------------

        System.out.println(record1.fullProfile());
        System.out.println(record2.fullProfile());
        System.out.println(record3.fullProfile());

        System.out.println(
                "Total records: "
                        + CompanyEmployeeRecord.totalRecords);
    }
}