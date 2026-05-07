package service;

import java.sql.*;
import model.Customer;

public class CustomerService implements InventoryOperations<Customer> {

    Connection con;

    public CustomerService(Connection con) {
        this.con = con;
    }

    @Override
    public void add(Customer c) {

        try {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO Customer (customer_id, customer_name, phone) VALUES (?,?,?)"
            );

            ps.setInt(1, c.getCustomerId());
            ps.setString(2, c.getName());
            ps.setString(3, c.getPhone());

            ps.executeUpdate();
            System.out.println("Customer added");

            ps.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void view() {

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Customer");
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
    public void update(int id, Customer c) {

        try {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE Customer SET customer_name=?, phone=? WHERE customer_id=?"
            );

            ps.setString(1, c.getName());
            ps.setString(2, c.getPhone());
            ps.setInt(3, id);

            ps.executeUpdate();

            System.out.println("Customer updated");

            ps.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void delete(int id) {

        try {
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM Customer WHERE customer_id=?"
            );

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Customer deleted");

            ps.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}