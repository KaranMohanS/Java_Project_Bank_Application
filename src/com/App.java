package com;

import com.account.Account;
import com.bank.Bank;
import com.branch.Branch;
import com.user.User;
import java.util.Scanner;
public class App {

    public static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

          User user=new User(0, "karan", 12, "male", 993848949l, "sirumugai");
         // User user1=new User(1, "karan", 12, "male", 993848949l, "sirumugai");
//
          User.adduser(user);
       // User.adduser(user1);
         User.printuser();
       //// User.getuser(1);
//
       //// User.update(1, "age");
       // //User.printuser();
       //// User.delete(1);
       // System.out.println("----");
       //// User.printuser();
//
       //Account.addaccount();
       //Account.printaccount();
       //Account.getaccount();
       Bank bank = new Bank();
       Bank.banks.add(bank);
       Bank.addbranch();
       Bank.addbranch();
       Bank.printbranch();
       //Bank.getbranch();
       //Bank.updatebranch();
       //Bank.printbranch();
       //Bank.deletebranch();
       //Bank.printbranch();

       Branch.addaccount();
       Branch.addaccount();
       Branch.printaccounts();
      // Branch.getaccount();
//
      // Branch.updateaccount();
      // Branch.printaccounts();
      // Branch.deleteaccount();
      // Branch.printaccounts();
         
     // Account.deposit();
     // Branch.printaccounts();
     // Account.withdrawel();
     //Account.transfer();
     // Branch.printaccounts();
     Account.checkbalance();
     
     Account.addcard();
     Account.addcard();
     Account.printcard();

       //Bank.addatm();
       //Bank.addatm();
       //Bank.printatm();
       //Bank.updateatm();
       //Bank.printatm();



    }
}
