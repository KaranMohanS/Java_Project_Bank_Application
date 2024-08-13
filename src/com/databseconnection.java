package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databseconnection {
    private static final String path = "jdbc:mysql://localhost:3306/bank";
    private static final String username="root";
    private static final String password="1234";

   


    public static Connection GetConnection() throws SQLException
    {
        
        return DriverManager.getConnection(path, username, password);

    }
}
/*
 * User user=new User(0, "karan", 12, "male", 993848949l, "sirumugai");
 * // User user1=new User(1, "karan", 12, "male", 993848949l, "sirumugai");
 * //
 * User.adduser(user);
 * // User.adduser(user1);
 * User.printuser();
 * //// User.getuser(1);
 * //
 * //// User.update(1, "age");
 * // //User.printuser();
 * //// User.delete(1);
 * // System.out.println("----");
 * //// User.printuser();
 * //
 * //Account.addaccount();
 * //Account.printaccount();
 * //Account.getaccount();
 * Bank bank = new Bank();
 * Bank.banks.add(bank);
 * Bank.addbranch();
 * Bank.addbranch();
 * Bank.printbranch();
 * //Bank.getbranch();
 * //Bank.updatebranch();
 * //Bank.printbranch();
 * //Bank.deletebranch();
 * //Bank.printbranch();
 * 
 * Branch.addaccount();
 * Branch.addaccount();
 * Branch.printaccounts();
 * // Branch.getaccount();
 * //
 * // Branch.updateaccount();
 * // Branch.printaccounts();
 * // Branch.deleteaccount();
 * // Branch.printaccounts();
 * 
 * // Account.deposit();
 * // Branch.printaccounts();
 * // Account.withdrawel();
 * //Account.transfer();
 * // Branch.printaccounts();
 * Account.checkbalance();
 * 
 * Account.addcard();
 * Account.addcard();
 * Account.printcard();
 * 
 * //Bank.addatm();
 * //Bank.addatm();
 * //Bank.printatm();
 * //Bank.updateatm();
 * //Bank.printatm();
 * 
 * 
 * 
 * //1 BankJdbc.addbank();
 * //BankJdbc.printbank();
 * 
 * //BranchJdbc.addbranch();
 * //BranchJdbc.printbranch();
 * //BranchJdbc.getbranch();
 * //BranchJdbc.updatebranch();
 * //BranchJdbc.deletebranch();
 * 
 * //Userjdbc.adduser();
 * //Userjdbc.printaccount();
 * //Userjdbc.getuser();
 * //Userjdbc.deleteuser();
 * //Userjdbc.updateuser();
 */