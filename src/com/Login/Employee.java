package com.Login;

public class Employee extends UserLogin{
    
    private String type;

    public Employee(String name,int password,String type)
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
