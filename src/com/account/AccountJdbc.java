package com.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.App;
import com.databseconnection;

public class AccountJdbc {
    // CRUD operations
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

    public static void getaccount() {
        System.out.println("enter get query");
        String query = App.scanner.nextLine();

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

    public static void deleteaccount() {
        System.out.println("enter delete query");
        String path = App.scanner.nextLine();

        try {

            Connection c = databseconnection.GetConnection();
            Statement s = c.createStatement();
            int row = s.executeUpdate(path);

            System.out.println("number of row affected: " + row);

            c.close();
            s.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    // -----------------------------------------------------------------------

    // withdrawel
    public static void whithdrawel() throws Exception {
        System.out.println("enter account number");
        long account_no = App.scanner.nextLong();
        App.scanner.nextLine();

        System.out.println("enter whithdrawel amount");
        double amount = App.scanner.nextDouble();
        App.scanner.nextLine();

        double newamount = currentamount(account_no);

        if (newamount >= amount) {
            double newbalance = newamount - amount;

            String query = "update account set balance=? where accountNumber=?";

            try {

                Connection c = databseconnection.GetConnection();
                PreparedStatement p = c.prepareStatement(query);
                p.setDouble(1, newbalance);
                p.setLong(2, account_no);

                int row = p.executeUpdate();
                System.out.println(" --- Withdrawel Amount Successful ---");
                System.out.println("number of row affected: " + row);

                c.close();
                p.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }

    public static double currentamount(long acno) {

        String query = "select balance from account where accountNumber=?";

        try {
            Connection c = databseconnection.GetConnection();
            PreparedStatement p = c.prepareStatement(query);
            p.setLong(1, acno);

            ResultSet rs = p.executeQuery();

            while (rs.next()) {
                return rs.getDouble("balance");
            }
            c.close();
            p.close();
            rs.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return 0.0;
    }
 // --------------------------------------------------------

    // Deposit
    public static void deposit() {
        System.out.println("enter account number");
        long account_no = App.scanner.nextLong();
        App.scanner.nextLine();

        System.out.println("enter deposit amount");
        double amount = App.scanner.nextDouble();
        App.scanner.nextLine();

        Double newbalance = getbalance(account_no);
        newbalance += amount;

        String query = "update account set balance=? where accountNumber=?";

        try (Connection c = databseconnection.GetConnection();
                PreparedStatement p = c.prepareStatement(query)) {
            p.setDouble(1, newbalance);
            p.setLong(2, account_no);

            int row = p.executeUpdate();
            System.out.println(" --- Deposit Amount Successful --- ");
            System.out.println("number of row affected: " + row);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static double getbalance(long accno) {
        String query = "select balance from account where accountNumber=?";

        try (Connection c = databseconnection.GetConnection();
                PreparedStatement p = c.prepareStatement(query)) {
            p.setLong(1, accno);

            ResultSet rs = p.executeQuery();

            while (rs.next()) {
                return rs.getDouble("balance");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return 0.0;
    }

    // ---------------------------------------------------------------

    public static void balance() {
        System.out.println("enter account number");
        long account_no = App.scanner.nextLong();
        App.scanner.nextLine();
        
        String query="select balance from account where accountNumber=?";

        try (Connection c=databseconnection.GetConnection();
             PreparedStatement p=c.prepareStatement(query)) {
            
                p.setLong(1, account_no);

            ResultSet rs=p.executeQuery();

            while (rs.next()) {
                System.out.println("Your Balance : "+rs.getDouble("balance"));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
