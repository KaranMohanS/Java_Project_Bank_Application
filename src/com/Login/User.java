package com.Login;

public class User extends UserLogin{
    
    private String type;
    public User(String name,int password,String type)
    {
        super(name, password);
        this.type=type;
    }

    public String gettype()
    {
        return type;
    }
    public void settype(String type)
    {
        this.type=type;
    }

    
}
