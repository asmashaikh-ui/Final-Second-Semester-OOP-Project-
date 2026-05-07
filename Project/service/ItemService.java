package service;

import java.sql.*;
import model.Item;

public class ItemService implements InventoryOperations<Item> {

    Connection con;

    public ItemService(Connection con) {
        this.con = con;
    }

    @Override
    public void add(Item item) {

        try {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO Item (item_id, item_name, unit_price, reorder_level, available_quantity, category) VALUES (?,?,?,?,?,?)"
            );

            ps.setInt(1, item.getItemId());
            ps.setString(2, item.getItemName());
            ps.setDouble(3, item.getUnitPrice());
            ps.setInt(4, item.getReorderLevel());
            ps.setInt(5, item.getAvailableQuantity());
            ps.setString(6, item.getCategory());

            ps.executeUpdate();
            System.out.println("Item added successfully");

            ps.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void view() {

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Item");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt(1);
                String name = rs.getString(2);
                double price = rs.getDouble(3);
                int reorder = rs.getInt(4);
                int qty = rs.getInt(5);
                String cat = rs.getString(6);

                System.out.println(id + " | " + name + " | " + price + " | " + reorder + " | " + qty + " | " + cat);

                if (qty <= reorder) {
                    System.out.println("⚠ LOW STOCK: " + id);
                }
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(int id, Item item) {

        try {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE Item SET unit_price=?, available_quantity=? WHERE item_id=?"
            );

            ps.setDouble(1, item.getUnitPrice());
            ps.setInt(2, item.getAvailableQuantity());
            ps.setInt(3, id);

            int rows = ps.executeUpdate();

            System.out.println(rows > 0 ? "Item updated" : "Item not found");

            ps.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void delete(int id) {

        try {
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM Item WHERE item_id=?"
            );

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            System.out.println(rows > 0 ? "Item deleted" : "Item not found");

            ps.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}