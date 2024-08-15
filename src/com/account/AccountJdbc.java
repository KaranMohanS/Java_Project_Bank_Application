package com.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.App;
import com.databseconnection;

public class AccountJdbc {

    public static void addaccount() {
        System.out.println("enter account holder name");
        String name = App.scanner.nextLine();

        System.out.println("enter account type");
        String type = App.scanner.nextLine();

        System.out.println("eneter branch id");
        int branchId = App.scanner.nextInt();
        App.scanner.nextLine();

        System.out.println("enter user id");
        int userId = App.scanner.nextInt();
        App.scanner.nextLine();

        System.out.println("enter balance");
        double balance = App.scanner.nextDouble();
        App.scanner.nextLine();

        String query = "insert into account(name,accountType,branchId,userId,balance) values(?,?,?,?,?)";

        try {
            Connection c = databseconnection.GetConnection();
            PreparedStatement p = c.prepareStatement(query);
            p.setString(1, name);
            p.setString(2, type);
            p.setInt(3, branchId);
            p.setInt(4, userId);
            p.setDouble(5, balance);

            int row = p.executeUpdate();
            System.out.println("number of row affected: " + row);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void printaccounts() {

        String query = "select * from account";

        try {
            Connection c = databseconnection.GetConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(query);

            while (rs.next()) {
                System.out.println("Account number: " + rs.getLong(1) + "\n" +
                        "Account holder name: " + rs.getString(2) + "\n" +
                        "Account type: " + rs.getString(3) + "\n" +
                        "Branch number: " + rs.getInt(4) + "\n" +
                        "User id: " + rs.getInt(5) + "\n" +
                        "Account balance: " + rs.getDouble(6) + "\n");
            }
            c.close();
            s.close();
            rs.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
