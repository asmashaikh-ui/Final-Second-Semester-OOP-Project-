package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Sales;

public class SaleService {

    Connection con;

    public SaleService(Connection con) {
        this.con = con;
    }

    public void addSale(Sales s) {

        try {

            // Check stock availability
            PreparedStatement check = con.prepareStatement(
                "SELECT available_quantity, reorder_level FROM Item WHERE item_id = ?"
            );

            check.setInt(1, s.getItemId());
            ResultSet rs = check.executeQuery();

            if (!rs.next()) {
                System.out.println("Item not found!");
                return;
            }

            int stock  = rs.getInt(1);
            int reorder = rs.getInt(2);

            if (stock < s.getQuantitySold()) {
                System.out.println("Not enough stock! Available: " + stock);
                check.close();
                return;
            }

            // Insert sale record
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO Sales (sale_id, total_price, item_id, customer_id, sale_date, quantity_sold) VALUES (?,?,?,?,?,?)"
            );

            ps.setInt(1, s.getSaleId());
            ps.setDouble(2, s.getTotalPrice());
            ps.setInt(3, s.getItemId());
            ps.setInt(4, s.getCustomerId());
            ps.setDate(5, java.sql.Date.valueOf(s.getSaleDate()));
            ps.setInt(6, s.getQuantitySold());

            ps.executeUpdate();

            // Deduct stock
            PreparedStatement ps2 = con.prepareStatement(
                "UPDATE Item SET available_quantity = available_quantity - ? WHERE item_id = ?"
            );

            ps2.setInt(1, s.getQuantitySold());
            ps2.setInt(2, s.getItemId());
            ps2.executeUpdate();

            System.out.println("Sale completed successfully.");

            // Low stock warning after sale
            int newStock = stock - s.getQuantitySold();
            if (newStock <= reorder) {
                System.out.println("⚠  LOW STOCK WARNING: Item ID " + s.getItemId()
                    + " has only " + newStock + " units left (Reorder Level: " + reorder + ")");
            }

            check.close();
            ps.close();
            ps2.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void viewSales() {

        try {
            PreparedStatement ps = con.prepareStatement(
                "SELECT s.sale_id, i.item_name, c.customer_name, s.quantity_sold, s.total_price, s.sale_date " +
                "FROM Sales s " +
                "JOIN Item i ON s.item_id = i.item_id " +
                "JOIN Customer c ON s.customer_id = c.customer_id"
            );

            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- SALES HISTORY ---");
            while (rs.next()) {
                System.out.println(
                    rs.getInt(1) + " | " +
                    rs.getString(2) + " | " +
                    rs.getString(3) + " | Qty: " +
                    rs.getInt(4) + " | Total: " +
                    rs.getDouble(5) + " | Date: " +
                    rs.getDate(6)
                );
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
