package com.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.databseconnection;

public class BankJdbc {

    //public static Scanner scanner=new Scanner(System.in);


    public static void addbank() throws SQLException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter bank name");
        String name = scanner.nextLine();

        System.out.println("enter bank address");
        String address = scanner.nextLine();
        

        String query = "INSERT INTO Bank (bank_name, bank_address) VALUES (?, ?)";

        Connection connection = databseconnection.GetConnection();
        PreparedStatement p = connection.prepareStatement(query);
           

        p.setString(1, name);
        p.setString(2, address);

        int row = p.executeUpdate();
        System.out.println("number of row affected: " + row);

      connection.close();
      p.close();
      scanner.close();

    }
    

    public static void updatebank() throws SQLException
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter id");
        int id=scanner.nextInt();
        scanner.nextLine();

        System.out.println("enter address");
        String add=scanner.nextLine();

        String query="update Bank set bank_address=? where id=?";

        Connection connection=databseconnection.GetConnection();
        PreparedStatement p=connection.prepareStatement(query);

        p.setInt(1, id);
        p.setString(2, add);

        int row=p.executeUpdate();
        System.out.println("number of row affected: "+row);
        
        connection.close();
        scanner.close();
    }

    public static void printbank() throws SQLException
    {
        //System.out.println("enter id");
        //int id=scanner.nextInt();
        //scanner.nextInt();
       
        String query="select * from Bank";
        Connection connection=databseconnection.GetConnection();
        java.sql.Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery(query);
        while (rs.next()) {
            
            System.out.println("id: "+rs.getInt(1)+"\n"+"name: "+rs.getString(2)+"\n"+"address: "+rs.getString(3));
        }
        connection.close();
        st.close();
        rs.close();
        
    }

}