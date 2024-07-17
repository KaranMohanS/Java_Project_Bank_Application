package com.card;

public class Card {
    



    long c_no;
    String user_name;
    String type;
    double balance;
    int pin;
    


    public Card(Long c_no,String user_name,String type,double balance,int pin)
    {
        this.c_no=c_no;
        this.user_name=user_name;
        this.type=type;
        this.balance=balance;
        this.pin=pin;
    }


    public long getC_no() {
        return c_no;
    }


    public void setC_no(long c_no) {
        this.c_no = c_no;
    }


    public String getUser_name() {
        return user_name;
    }


    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public double getBalance() {
        return balance;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }


    public int getPin() {
        return pin;
    }


    public void setPin(int pin) {
        this.pin = pin;
    }


    @Override
    public String toString() {
        return "Card [c_no=" + c_no + ", user_name=" + user_name + ", type=" + type + ", balance=" + balance + ", pin="
                + pin + "]";
    }

    

}
