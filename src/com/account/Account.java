package com.account;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.InputMismatchException;
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

    public static void addcard() throws Exception
    {
        System.out.println("enter card number");
        long cno=checkcard();

        System.out.println("enter user name");
        String name=chechname();

        System.out.println("enter card type");
        String type=App.scanner.nextLine();

        double balance=getbalance(type);

        System.out.println("enter pin");
        int pin=App.scanner.nextInt();
        App.scanner.nextLine();

        Card card=new Card(cno, name, type, balance, pin);
        addcard(card);

    }
    public static void addcard(Card card)
    {
       cards.add(card);
    }

    public static String chechname() throws EOFException
    {
        String name=App.scanner.nextLine();
        boolean found=false;
        for(User x:User.list)
        {
            if(x.getName().equals(name))
            {
               found=true;
               break;
            }
        }
        if(found)
        {
            return name;
        }
        else
        {
            throw new EOFException("invalied name: "+name);
        }
    }

    public static double getbalance(String type) throws Exception
    {
        double currentbalance=0.0;
        switch (type) {
            
            case "debit":
                
                for(Map.Entry<Long,Account> x:Branch.map.entrySet())
                {
                    
                    System.out.println("enter account number");
                    long ac=App.scanner.nextLong();
                    App.scanner.nextLine();

                    if(x.getKey()==ac)
                    {
                        Account account=x.getValue();
                         currentbalance=account.getBalance();
                         break;
                    }
                }
                
                break;
            case "credit":

               double max=50000;
               currentbalance=max;   
        
            default:
                throw new Exception("invalied option: "+type);
                
        }
        return currentbalance;
    }

    public static long checkcard() throws Exception {
       

       System.out.println("enter account number");
       long a=App.scanner.nextLong();
       App.scanner.nextLine();

       long cno = App.scanner.nextLong();
        App.scanner.nextLine();
        boolean found=false;
        for(Map.Entry<Long,Account> x: Branch.map.entrySet())
        {
            if(x.getKey()==a)
            {
                Account account=x.getValue();

                if(account.getCard_no()==cno)
                {
                  found=true;
                  break;
                }
            }
        }
        if(found)
        {
            return cno;
        }
        else
        {
            throw new Exception("invalied card number: "+cno);
        }
        
    
    }


   public static void printcard()
   {
     for(Card x:cards)
     {
        System.out.println(x);
     }
   }





    long account_no;
    String name;
    String account_type;
    int branch_id;
    int user_id;
    long card_no;
    double balance;
    

    
    
   


    public Account(long account_no, String name, String account_type, int branch_id, int user_id, long card_no,
            double balance) {
        this.account_no = account_no;
        this.name = name;
        this.account_type = account_type;
        this.branch_id = branch_id;
        this.user_id = user_id;
        this.card_no = card_no;
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
    public long getCard_no() {
        return card_no;
    }
    public void setCard_no(long card_no) {
        this.card_no = card_no;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Account [account_no=" + account_no + ", name=" + name + ", account_type=" + account_type
                + ", branch_id=" + branch_id + ", user_id=" + user_id + ", card_no=" + card_no + ", balance=" + balance
                + "]";
    }


   

    
}
