package com.Login;


public class UserLogin {

    private String name;
    private int password;


    public UserLogin(String name, int password) {
        this.name = name;
        this.password = password;
    }
    
    public String getname()
    {
        return this.name;
    }
    public void setname(String name)
    {
        this.name=name;
    }

    public int getpassword()
    {
        return password;
    }
    public void setpassword(int password)
    {
        this.password=password;
    }

    
}

