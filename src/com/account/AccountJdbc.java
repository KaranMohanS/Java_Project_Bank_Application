package com.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.App;
import com.databseconnection;

public class AccountJdbc {
    
public static void addaccount()
{
    System.out.println("enter account holder name");
    String name=App.scanner.nextLine();

    System.out.println("enter account type");
    String type=App.scanner.nextLine();

    System.out.println("eneter branch id");
    int branchId=App.scanner.nextInt();
    App.scanner.nextLine();

    System.out.println("enter user id");
    int userId=App.scanner.nextInt();
    App.scanner.nextLine();

    System.out.println("enter balance");
    double balance=App.scanner.nextDouble();
    App.scanner.nextLine();

    String query="insert into account(name,accountType,branchId,userId,balance) values(?,?,?,?,?)";

    try {
        Connection c=databseconnection.GetConnection();
        PreparedStatement p=c.prepareStatement(query);
        p.setString(1, name);
        p.setString(2, type);
        p.setInt(3, branchId);
        p.setInt(4, userId);
        p.setDouble(5, balance);

       int row= p.executeUpdate();
       System.out.println("number of row affected: "+row);        
        
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}


}
