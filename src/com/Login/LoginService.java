package com.Login;

import java.io.File;
import java.io.FileWriter;

import com.App;

public class LoginService {
    
    public static String path="login.txt";

    public static void createaccount()
    {
        System.out.println("enter name");
        String name=App.scanner.nextLine();

        System.out.println("enter password");
        int pass=App.scanner.nextInt();
        App.scanner.nextLine();

        System.out.println("enter user-->1 or employee-->2 id creation");
        int id=App.scanner.nextInt();
        App.scanner.nextLine();

        if(id==1)
        {
            UserLogin user1=new User(name, pass, "User");
            createaccount(user1,id);
        }
        else if(id==2)
        {
            UserLogin user2=new Employee(name, pass,"Employee");
            createaccount(user2,id);
        } else
            try {
                throw new Exception("invalid option :"+id);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }

    public static void createaccount(UserLogin user,int id)
    {
        File file=new File(path);
        try (FileWriter fileWriter=new FileWriter(file,true)) {
            if(id==1)
            fileWriter.write(user.getname()+","+user.getpassword()+","+((User) user).gettype()+"\n");
            else
            fileWriter.write(user.getname()+","+user.getpassword()+","+((Employee) user).gettype()+"\n");

            System.out.println("--- Id Sucessfully Created ---");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
