package com.atm;

public class Atm {
    

    int atm_id;
    String address;
    int bank_id;

    public Atm(int atm_id,String address,int bank_id)
    {
        this.atm_id=atm_id;
        this.address=address;
        this.bank_id=bank_id;
    }

    public int getAtm_id() {
        return atm_id;
    }

    public void setAtm_id(int atm_id) {
        this.atm_id = atm_id;
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

    
}
