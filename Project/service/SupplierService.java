package service;

import java.sql.*;
import model.Supplier;

public class SupplierService implements InventoryOperations<Supplier> {

    Connection con;

    public SupplierService(Connection con) {
        this.con = con;
    }

    @Override
    public void add(Supplier s) {

        try {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO Supplier (supplier_id, supplier_name, phone) VALUES (?,?,?)"
            );

            ps.setInt(1, s.getSupplierId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getPhone());

            ps.executeUpdate();
            System.out.println("Supplier added");

            ps.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void view() {

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Supplier");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3));
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(int id, Supplier s) {

        try {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE Supplier SET supplier_name=?, phone=? WHERE supplier_id=?"
            );

            ps.setString(1, s.getName());
            ps.setString(2, s.getPhone());
            ps.setInt(3, id);

            ps.executeUpdate();

            System.out.println("Supplier updated");

            ps.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void delete(int id) {

        try {
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM Supplier WHERE supplier_id=?"
            );

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Supplier deleted");

            ps.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}