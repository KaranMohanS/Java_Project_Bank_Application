package com.account;


public class Account {
    
    
    

  











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
