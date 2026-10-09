package day2_live_coding.assigment_problems;

public class ProductInventoryCsvParser {

    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null || csvLine.trim().isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String qty = fields[2].trim();

        if (productName.isEmpty() || sku.isEmpty() || qty.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.printf("Product: %s | SKU: %s | Qty: %s%n", productName, sku, qty);
    }

    public static void main(String[] args) {
        System.out.println("=== Product Inventory CSV Parser ===");
        System.out.print("Input: \"Wireless Mouse,WM-2201,150\" -> ");
        parseInventoryRecord("Wireless Mouse,WM-2201,150");

        System.out.print("Input: \"Wireless Mouse,150\" -> ");
        parseInventoryRecord("Wireless Mouse,150");
    }
}
