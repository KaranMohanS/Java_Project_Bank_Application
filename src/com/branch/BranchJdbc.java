package com.branch;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.App;
import com.databseconnection;

public class BranchJdbc {
    
    public static void addbranch()
    {
        
        System.out.println("enter branch name");
        String name=App.scanner.nextLine();

        System.out.println("enter bank id");
        int bid=App.scanner.nextInt();
        App.scanner.nextLine();

        String query="insert into branch(name,bid) values(?,?)";

        
        try (Connection connection=databseconnection.GetConnection();PreparedStatement p=connection.prepareStatement(query)) {
            p.setString(1, name);
            p.setInt(2, bid);
            int row=p.executeUpdate();
            System.out.println("number of row affected: "+row);
        } catch (Exception e) {
            // TODO: handle exception
        }

         
    }

    public static void printbranch()
    {
        String query="select * from branch";

        try (Connection connection=databseconnection.GetConnection();
             java.sql.Statement s=connection.createStatement();
             ResultSet rs=s.executeQuery(query)) {

                while (rs.next()) {
                    
                    System.out.println("branch id: "+rs.getInt(1)+"\n"+"branch name: "+rs.getString(2)+"\n"+"bank id: "+rs.getInt(3)+"\n");
                }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void getbranch()
    {
        System.out.println("enter get query");
        String query=App.scanner.nextLine();

        try (Connection connection=databseconnection.GetConnection();
             java.sql.Statement s=connection.createStatement();
             ResultSet rs=s.executeQuery(query)) {
            
                while (rs.next()) {
                    System.out.println("branch id: "+rs.getInt(1)+"\n"+"branch name: "+rs.getString(2)+"\n"+"bank id: "+rs.getInt(3)+"\n");

                }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void updatebranch()
    {
        System.out.println("enter update query");
        String query=App.scanner.nextLine();

        try (Connection connection=databseconnection.GetConnection();
             Statement s=connection.createStatement();
             ) {
            int row=s.executeUpdate(query);
            System.out.println("number of row affected: "+row);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void deletebranch()
    {
        System.out.println("enter update query");
        String query=App.scanner.nextLine();

        try {
            Connection connection=databseconnection.GetConnection();
            Statement s=connection.createStatement();
            int row =s.executeUpdate(query);
            System.out.println("number of row affected: "+row);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
