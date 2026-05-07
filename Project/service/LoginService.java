package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService {

    Connection con;

    public LoginService(Connection con) {
        this.con = con;
    }

    public boolean login(String username, String password) {

        try {

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM admin WHERE username = ? AND password = ?"
            );

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }
}