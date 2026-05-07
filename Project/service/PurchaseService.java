package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Purchase;

public class PurchaseService {

    Connection con;

    public PurchaseService(Connection con) {
        this.con = con;
    }

    public void addPurchase(Purchase p) {

        try {

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO Purchase (purchase_id, quantity, item_id, supplier_id, cost_price, purchase_date) VALUES (?,?,?,?,?,?)"
            );

            ps.setInt(1, p.getPurchaseId());
            ps.setInt(2, p.getQuantity());
            ps.setInt(3, p.getItemId());
            ps.setInt(4, p.getSupplierId());
            ps.setDouble(5, p.getCostPrice());
            ps.setDate(6, java.sql.Date.valueOf(p.getDate()));

            ps.executeUpdate();

            // Update stock after purchase
            PreparedStatement ps2 = con.prepareStatement(
                "UPDATE Item SET available_quantity = available_quantity + ? WHERE item_id = ?"
            );

            ps2.setInt(1, p.getQuantity());
            ps2.setInt(2, p.getItemId());
            ps2.executeUpdate();

            System.out.println("Purchase added and stock updated successfully.");

            ps.close();
            ps2.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void viewPurchases() {

        try {
            PreparedStatement ps = con.prepareStatement(
                "SELECT p.purchase_id, i.item_name, s.supplier_name, p.quantity, p.cost_price, p.purchase_date " +
                "FROM Purchase p " +
                "JOIN Item i ON p.item_id = i.item_id " +
                "JOIN Supplier s ON p.supplier_id = s.supplier_id"
            );

            java.sql.ResultSet rs = ps.executeQuery();

            System.out.println("\n--- PURCHASE HISTORY ---");
            while (rs.next()) {
                System.out.println(
                    rs.getInt(1) + " | " +
                    rs.getString(2) + " | " +
                    rs.getString(3) + " | Qty: " +
                    rs.getInt(4) + " | Cost: " +
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
