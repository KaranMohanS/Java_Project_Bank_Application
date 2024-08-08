package com.user;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.*;
public class UserService {

    public static List<User> list=new ArrayList<>();
    
    public static String path="user.txt";

    public static void adduser()
    {
        System.out.println("enter id");
        int id=App.scanner.nextInt();
        App.scanner.nextLine();

        System.out.println("enter name");
        String name=App.scanner.nextLine();

        System.out.println("enter age");
        int age=App.scanner.nextInt();
        App.scanner.nextLine();

        System.out.println("enter gender");
        String gender=App.scanner.nextLine();

        System.out.println("enter phone number");
        long ph=App.scanner.nextLong();
        App.scanner.nextLine();

        System.out.println("enter address");
        String add=App.scanner.nextLine();

        User user =new User(id, name, age, gender, ph, add);
        adduser(user);

    }

    public static void adduser(User user)
    {
        File file=new File(path);
        try(FileWriter fileWriter=new FileWriter(file,true))
        {

         fileWriter.write(user.getId()+","+user.getName()+","+user.getAge()+","+user.getGender()+","+user.getPh()+","+user.getAddress()+"\n");
         list.add(user);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}


public static void printuser()
{
    File file=new File(path);
    try (FileReader fileReader = new FileReader(file)) {
        int line;
        while ((line=fileReader.read())!=-1) {
            System.out.print((char)line);
        }
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}


 public static User getuser() throws NumberFormatException, IOException
 {
    System.out.println("enter id");
    int id=App.scanner.nextInt();
    App.scanner.nextLine();

    File file=new File(path);
   
    try ( FileReader fileReader = new FileReader(file);BufferedReader bufferedReader=new BufferedReader(fileReader)) {
       
        User user=null;
        String line;

        while ((line=bufferedReader.readLine())!=null) {
            String arr[]=line.split(",");

            if(arr.length>5 && Integer.parseInt(arr[0])==id)
            {
                user =new User(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]), arr[3], Long.parseLong(arr[4]), arr[5]);
                break;
                
            }

        }
      return user;
    } 
 }

 public static void deleteuser() throws IOException
 {
    System.out.println("enter id");
    int id=App.scanner.nextInt();
    App.scanner.nextLine();

    File file=new File(path);
    File temp=new File("temp.txt");

    try(BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
        BufferedWriter BufferedWriter=new java.io.BufferedWriter(new FileWriter(temp)))
        {
            String line;
            

            while ((line=bufferedReader.readLine())!=null) {
                String[] arr=line.split(",");

                if(arr.length>5 && Integer.parseInt(arr[0])==id )
                {
                    continue;
                }
                BufferedWriter.write(line+System.lineSeparator());
            }
        }
        if(!file.delete())
        {
           try {
            throw new Exception("File not delete");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }
        if(!temp.renameTo(file))
        {
            try {
                throw new Exception("File not rename to original file");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
 }


 public static void updateuser()
 {
    System.out.println("enter id");
    int id=App.scanner.nextInt();
    App.scanner.nextLine();

    File file=new File(path);
    File temp=new File("temp.txt");
    
    try (BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
         BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(temp))) {
        
            String line;
            User user=null;

            while ((line=bufferedReader.readLine())!=null) {
                String[] arr=line.split(",");
                
                if(arr.length>5 && Integer.parseInt(arr[0])==id)
                {
                    System.out.println("enter option: 1 name | 2 age | 3 gender | 4 ph | 5 address ");
                    int option=App.scanner.nextInt();
                    App.scanner.nextLine();

                    switch (option) {
                        case 1:
                             System.out.println("current name: "+arr[1]);
                             System.out.println("enter new name");
                             String newname=App.scanner.nextLine();
                             arr[1]=newname;
                            break;
                        
                        case 2:
                             System.out.println("current age: "+Integer.parseInt(arr[2]));
                             System.out.println("enter new age");
                             int age=App.scanner.nextInt();
                             App.scanner.nextLine();

                             arr[2]=String.valueOf(age);
                             break;

                        case 3:
                            System.out.println("current gender: "+arr[3]);
                            System.out.println("enter new gender");
                            String newgender=App.scanner.nextLine();
                            arr[3]=newgender;
                            break;

                        case 4:
                            
                           System.out.println("current ph: "+Long.parseLong(arr[4]));
                           System.out.println("enter new ph");
                           long ph=App.scanner.nextInt();
                            App.scanner.nextLine();
                            arr[4]=String.valueOf(ph);
                            break;

                        case 5:

                           System.out.println("current address: "+arr[5]);
                           System.out.println("enter new address");
                           String newaddress=App.scanner.nextLine();
                           arr[5]=newaddress;
                           break;

                        case 6:
                            break;
                        default:

                           throw new Exception("invalied option: "+option);
                    }
                    user=new User(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]), arr[3], Long.parseLong(arr[4]), arr[5]);
                }
                bufferedWriter.write(String.join(",",arr)+System.lineSeparator());
            }
            if(!file.delete())
        {
           try {
            throw new Exception("File not delete");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }
        if(!temp.renameTo(file))
        {
            try {
                throw new Exception("File not rename to original file");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    } catch (Exception e) {
        // TODO: handle exception
    }

 }
}
