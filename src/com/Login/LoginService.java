package com.Login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.App;

public class LoginService {
    
    public static String path="login.txt";

    public static void createaccount()          // createaccount
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

    //--------------------------------------------------------------

    public static boolean Loginaccess()
    {
        System.out.println("enter name");
        String name=App.scanner.nextLine();

        System.out.println("enter password");
        int pass=App.scanner.nextInt();
        App.scanner.nextLine();
        
        System.out.println("enter type");
        String type=App.scanner.nextLine();

        File file=new File(path);

        try (FileReader fileReader=new FileReader(file);
             BufferedReader bufferedReader=new BufferedReader(fileReader)) {
            
                String line;

                while ((line=bufferedReader.readLine())!=null) {
                    
                    String[] arr=line.split(",");

                    if(arr[0].equals(name) && Integer.parseInt(arr[1])==pass && arr[2].equals(type))
                    {
                        return true;
                    }
                }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }
  //------------------------------------------------------------------------------
}
