package com.account;

import java.io.EOFException;
import java.util.ArrayList;
//import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import com.card.*;
import com.App;
import com.branch.Branch;
import com.user.User;

public class Account {
    
    public static List<Card> cards=new ArrayList<>();
    
    public static void deposit()
    {
        System.out.println("enter account number");
        long account_no=App.scanner.nextLong();
        App.scanner.nextLine();

        for(Map.Entry<Long,Account> x:Branch.map.entrySet())
        {
               
            if(x.getKey()==account_no)
            {
                Account account=x.getValue();

                System.out.println("enter deposit amount");
                double amount=App.scanner.nextDouble();
                App.scanner.nextLine();

                double currentamount=account.getBalance();
                
                account.setBalance(currentamount+amount);
            }
            else
            {
                System.out.println("invalied account number");
                break;
            }
        }
        
    }

    public static void withdrawel()
    {
        System.out.println("enter account number");
        long account_no=App.scanner.nextLong();
        App.scanner.nextLine();

        for(Map.Entry<Long,Account> x:Branch.map.entrySet())
        {
            if(x.getKey()==account_no)
            {
                Account account=x.getValue();

                System.out.println("enter withdrawel amount");
                double amount=App.scanner.nextDouble();
                App.scanner.nextLine();

                double currentamount=account.getBalance();

                if(currentamount>=amount)
                {
                    account.setBalance(currentamount-amount);
                }
                else
                {
                    System.out.println("insufficient balance: "+currentamount);
                    break;
                }
            }
            else
            {
                System.out.println("Invalied account number: "+account_no);
                break;
            }

        }
    }


    public static void transfer() throws Exception
    {
       System.out.println("enter beneficiaries account number ");
       long account_no=App.scanner.nextLong();
       App.scanner.nextLine();

       System.out.println("enter beneficiaries name");
       String name=App.scanner.nextLine();

       System.out.println("enter ifsc number");
       String ifsc=App.scanner.nextLine();

       System.out.println("enter account number");
       long accountno=checkaid();

       System.out.println("enter transfer amount ");
       double amount=checkbalance(accountno);

       for(Map.Entry<Long,Account> x:Branch.map.entrySet())
       {
           if(x.getKey()==accountno)
           {
           Account account=x.getValue();
            
           double current=account.getBalance();
           System.out.println("Current balance: "+current);
           account.setBalance(current-amount);
           break;
           }

       }

    }

    public static long checkaid() throws Exception
    {
        long id=App.scanner.nextLong();
        boolean found=false;
        //Branch.map.get(id);
        for(Map.Entry<Long,Account> x:Branch.map.entrySet())
        {
            if(x.getKey()==id)
            {
               found=true;
               break;
            }
        }
        if(found)
        {
            return id;
        }
        else
        {
            throw new Exception("invalied account your number: "+id);
        }
    }


    public static double checkbalance(long account_no) throws EOFException
    {
        double amount=App.scanner.nextDouble();
        double currentamount;
        boolean found=false;
        for(Map.Entry<Long,Account> x:Branch.map.entrySet())
        {
            if(x.getKey()==account_no)
            {
                Account account=x.getValue();

                currentamount=account.getBalance();
                if(currentamount>=amount)
                {
                
                  found=true;
                  break;
                }
            }
        }
        if(found)
        {
            return amount;
        }
        else
        {
            throw new EOFException("invalied account number: "+account_no);
        }
    }
    

    public static void checkbalance()
    {
        System.out.println( "enter account number");
        long account_no=App.scanner.nextLong();
        App.scanner.nextLine();

        for(Map.Entry<Long,Account> x: Branch.map.entrySet())
        {
            if(x.getKey()==account_no)
            {
                Account account=x.getValue();
                System.out.println("Current balance: "+account.getBalance());
                break;
            }
        }
    }

//----------------------------------------------------------------------------------------------------------------------

   




    long account_no;
    String name;
    String account_type;
    int branch_id;
    int user_id;
    double balance;
    

    
    
   


    public Account(long account_no, String name, String account_type, int branch_id, int user_id, 
            double balance) {
        this.account_no = account_no;
        this.name = name;
        this.account_type = account_type;
        this.branch_id = branch_id;
        this.user_id = user_id;
        this.balance = balance;

    }
    public long getAccount_no() {
        return account_no;
    }


    public void setAccount_no(long account_no) {
        this.account_no = account_no;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public double getBalance() {
        return balance;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }


    public int getUser_id() {
        return user_id;
    }


    public String getAccount_type() {
        return account_type;
    }
    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }
    public int getBranch_id() {
        return branch_id;
    }
    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }
    
    
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {

        return "Account [account_no=" + account_no + ", name=" + name + ", account_type=" + account_type
                + ", branch_id=" + branch_id + ", user_id=" + user_id + ", balance=" + balance
                + "]";
    }


   

    
}
