package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DashboardService {

    Connection con;

    public DashboardService(Connection con) {
        this.con = con;
    }

    public void showDashboard() {

        try {

            // TOTAL ITEMS
            PreparedStatement ps1 = con.prepareStatement("SELECT COUNT(*) FROM Item");
            ResultSet rs1 = ps1.executeQuery();
            rs1.next();
            int items = rs1.getInt(1);

            // TOTAL SUPPLIERS
            PreparedStatement ps2 = con.prepareStatement("SELECT COUNT(*) FROM Supplier");
            ResultSet rs2 = ps2.executeQuery();
            rs2.next();
            int suppliers = rs2.getInt(1);

            // TOTAL CUSTOMERS
            PreparedStatement ps3 = con.prepareStatement("SELECT COUNT(*) FROM Customer");
            ResultSet rs3 = ps3.executeQuery();
            rs3.next();
            int customers = rs3.getInt(1);

            // TOTAL SALES  (fixed: table is "Sales" not "Sale")
            PreparedStatement ps4 = con.prepareStatement("SELECT COUNT(*) FROM Sales");
            ResultSet rs4 = ps4.executeQuery();
            rs4.next();
            int sales = rs4.getInt(1);

            // TOTAL PURCHASES
            PreparedStatement ps5 = con.prepareStatement("SELECT COUNT(*) FROM Purchase");
            ResultSet rs5 = ps5.executeQuery();
            rs5.next();
            int purchases = rs5.getInt(1);

            // LOW STOCK ITEMS
            PreparedStatement ps6 = con.prepareStatement(
                "SELECT COUNT(*) FROM Item WHERE available_quantity <= reorder_level"
            );
            ResultSet rs6 = ps6.executeQuery();
            rs6.next();
            int lowStock = rs6.getInt(1);

            // TOTAL REVENUE
            PreparedStatement ps7 = con.prepareStatement("SELECT COALESCE(SUM(total_price),0) FROM Sales");
            ResultSet rs7 = ps7.executeQuery();
            rs7.next();
            double revenue = rs7.getDouble(1);

            // DISPLAY DASHBOARD
            System.out.println("\n===== DASHBOARD =====");
            System.out.println("Total Items      : " + items);
            System.out.println("Total Suppliers  : " + suppliers);
            System.out.println("Total Customers  : " + customers);
            System.out.println("Total Sales      : " + sales);
            System.out.println("Total Purchases  : " + purchases);
            System.out.printf ("Total Revenue    : Rs. %.2f%n", revenue);
            System.out.println("Low Stock Items  : " + lowStock);

            if (lowStock > 0) {
                System.out.println("\n⚠  LOW STOCK ALERTS:");
                PreparedStatement psLow = con.prepareStatement(
                    "SELECT item_id, item_name, available_quantity, reorder_level FROM Item WHERE available_quantity <= reorder_level"
                );
                ResultSet rsLow = psLow.executeQuery();
                while (rsLow.next()) {
                    System.out.println("   Item ID: " + rsLow.getInt(1)
                        + " | " + rsLow.getString(2)
                        + " | Stock: " + rsLow.getInt(3)
                        + " | Reorder Level: " + rsLow.getInt(4));
                }
                rsLow.close();
                psLow.close();
            }

            rs1.close(); rs2.close(); rs3.close();
            rs4.close(); rs5.close(); rs6.close(); rs7.close();

            ps1.close(); ps2.close(); ps3.close();
            ps4.close(); ps5.close(); ps6.close(); ps7.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
