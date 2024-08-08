package com.user;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.App;
import com.databseconnection;

public class Userjdbc {
    
    public static void adduser()
    {
        System.out.println("enter insert query");
        String query=App.scanner.nextLine();

        try {
            Connection connection=databseconnection.GetConnection();
            Statement s=connection.createStatement();
            int row=s.executeUpdate(query);
            System.out.println("number of row affected: "+row);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void printaccount()
    {

        System.out.println("enter print query");
        String query=App.scanner.nextLine();

        try {
            Connection connection=databseconnection.GetConnection();
            Statement s=connection.createStatement();
            ResultSet rs=s.executeQuery(query);

            while (rs.next()) {
                System.out.println("user id: "+rs.getInt(1)+"\n"+"user name: "+rs.getString(2)+"\n"+"user age: "+rs.getInt(3)+"\n"+"user gender: "+rs.getString(4)+"\n"+
                "user ph: "+rs.getLong(5)+"\n"+"user address: "+rs.getString(6)+"\n");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public static void getuser()
    {
        System.out.println("enter user id");
        int id=App.scanner.nextInt();
        App.scanner.nextLine();

        String query="select * from user where id=?";

        try (Connection connection=databseconnection.GetConnection();
             PreparedStatement p=connection.prepareStatement(query)) {

                p.setInt(1, id);

            ResultSet rs=p.executeQuery();

            while (rs.next()) {
                

                System.out.println("user id: "+rs.getInt(1)+"\n"+"user name: "+rs.getString(2)+"\n"+"user age: "+rs.getInt(3)+"\n"+"user gender: "+rs.getString(4)+"\n"+
                "user ph: "+rs.getLong(5)+"\n"+"user address: "+rs.getString(6)+"\n");

            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void deleteuser()
    {
        System.out.println("enter user id");
        int id=App.scanner.nextInt();
        App.scanner.nextLine();

        String query="delete from user where id=?";

        try {
            Connection connection=databseconnection.GetConnection();
            PreparedStatement p=connection.prepareStatement(query);
            p.setInt(1, id);
            int row=p.executeUpdate();

            System.out.println("number of row affected: "+row);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void updateuser()
    {
     System.out.println("enter update query");
     String query=App.scanner.nextLine();
     
     try {
        Connection connection=databseconnection.GetConnection();
        Statement s=connection.createStatement();
        int row=s.executeUpdate(query);
        System.out.println("number of row affected: "+row);
     } catch (Exception e) {
        // TODO: handle exception
     }
    }
}
