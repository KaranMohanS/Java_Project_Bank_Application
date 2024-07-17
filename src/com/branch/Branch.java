package com.branch;

import java.util.*;
import com.App;
import com.account.Account;
import com.bank.Bank;
import com.card.Card;
import com.user.User;

public class Branch {

    public static Map<Long, Account> map = new HashMap<>();

    public static void addaccount() throws Exception {

        System.out.println("enter account number");
        long account_no = App.scanner.nextLong();
        App.scanner.nextLine();

        System.out.println("enter account holder name");
        String name = checkname();

        System.out.println("enter initial balance");
        double balance = App.scanner.nextDouble();
        App.scanner.nextLine();

        System.out.println("enter account type");
        String type = App.scanner.nextLine();

        System.out.println("enter branch id");
        int bid = checkbid();

        System.out.println("enter user id");
        int id = checkid();

        System.out.println("enter card number");
        long card = App.scanner.nextLong();
        App.scanner.nextLine();

        Account account = new Account(account_no, name, type, bid, id, card, balance);
        addaccount(account);

    }

    public static void addaccount(Account account) {
        map.put(account.getAccount_no(), account);
    }

    public static void printaccounts() {
        for (Map.Entry<Long, Account> x : map.entrySet()) {
            System.out.println(x);
        }
    }

    public static String checkname() throws Exception {
        String name = App.scanner.nextLine();
        boolean found = false;
        for (User x : User.list) {
            if (x.getName().equals(name)) {
                found = true;
                break;
            }
        }
        if (found) {
            return name;
        } else {
            throw new Exception("invalied name: " + name);
        }
    }

    public static int checkbid() throws Exception {

        int bid = App.scanner.nextInt();
        App.scanner.nextLine();
        boolean found = false;
        for (Branch x : Bank.list) {
            if (x.getBranch_id() == bid) {
                found = true;
                break;
            }
        }
        if (found) {
            return bid;
        } else {
            throw new Exception("invalied branch id: " + bid);
        }
    }

    public static int checkid() throws Exception {
        int id = App.scanner.nextInt();
        App.scanner.nextLine();
        boolean fount = false;
        for (User x : User.list) {
            if (x.getId() == id) {
                fount = true;
            }
        }
        if (fount) {
            return id;
        } else {
            throw new Exception("invalid id: " + id);
        }
    }

   
    // ---------------------------------------------------------------------------

    public static void getaccount() {
        System.out.println("enter account number");
        long account_no = App.scanner.nextLong();

        System.out.println(map.get(account_no));
    }
    // --------------------------------------------------------------------------

    public static void updateaccount() {


        System.out.println("enter account number");
        long a=App.scanner.nextLong();
        App.scanner.nextLine();
        boolean found=false;

        for(Map.Entry<Long,Account> x:map.entrySet())
        {
            if(x.getKey()==a)
            {
                Account account=x.getValue();
               System.out.println("enter option: 1 account number | 2 account type | 3 card number ");
               int option=App.scanner.nextInt();
               App.scanner.nextLine();

               switch (option) {
                case 1:
                     System.out.println("enetr new account number");
                     long newac=App.scanner.nextLong();
                     account.setAccount_no(newac);
                    break;
                case 2:
                    System.out.println("enter account type");
                    String newa=App.scanner.nextLine();

                    account.setAccount_type(newa);
                    break;

                case 3:
                     System.out.println("enter new card number");
                     long newc=App.scanner.nextLong();
                     App.scanner.nextLine();

                     account.setCard_no(newc);
                     break;
               
                default:
                    System.out.println("invalid option: "+option);
                    break;
               }
            }

        }

    }


    public static void deleteaccount()
    {
        System.out.println("enter account number");
        long account=App.scanner.nextLong();
        App.scanner.nextLine();

        map.remove(account);
    }

    int branch_id;
    String address;
    int bank_id;

    public Branch(int branch_id, String address, int bank_id) {
        this.branch_id = branch_id;
        this.address = address;
        this.bank_id = bank_id;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBank_id() {
        return bank_id;
    }

    public void setBank_id(int bank_id) {
        this.bank_id = bank_id;
    }

    @Override
    public String toString() {
        return "Branch [branch_id=" + branch_id + ", address=" + address + ", bank_id=" + bank_id + "]";
    }

}
