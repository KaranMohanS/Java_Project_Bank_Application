package com.account;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.App;
import com.branch.Branch;
import com.branch.BranchService;
import com.user.UserService;

public class AccountService {
    
    public static String path="account.txt";

    public static void addaccount() throws Exception
    {
        System.out.println("enter account number");
        long accno=App.scanner.nextLong();
        App.scanner.nextLine();

        System.out.println("enter user name");
        String name=checkname();

        System.out.println("enter account type");
        String type=App.scanner.nextLine();

        System.out.println("enter branch id");
        int bid=checkbid();

        System.out.println("enter user id");
        int id=checkid();

        System.out.println("enter balance");
        double balance=App.scanner.nextDouble();
        App.scanner.nextLine();

        Account account=new Account(accno, name, bid, id,type, balance);
        AccountService.addaccount(account);


    }

    public static void addaccount(Account account)
    {
        File file=new File(path);
        try (FileWriter fileWriter = new FileWriter(file,true)) {

            fileWriter.write(account.getAccount_no()+","+account.getName()+","+account.getBranch_id()+","+account.getUser_id()+","+account.getAccount_type()+","+account.getBalance()+"\n");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String checkname() throws Exception
    {
        String name=App.scanner.nextLine();

        File file=new File(UserService.path);
        boolean found=false;

        try {
            FileReader fileReader=new FileReader(file);
            BufferedReader b=new BufferedReader(fileReader);

            String line;
            while ((line=b.readLine())!=null) {
                String arr[]=line.split(",");

                if(arr[1].equals(name))
                {
                    found=true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(found)
        return name;
        else
        throw new Exception("invalied name: "+name);
    }

    public static int checkbid() throws Exception
    {
        int id=App.scanner.nextInt();
        App.scanner.nextLine();

        File file=new File(BranchService.path);
        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));

        String line;
        Boolean found=false;

        while ((line=bufferedReader.readLine())!=null) {
            String arr[]=line.split(",");

            if(Integer.parseInt(arr[0])==id)
            {
                found=true;
                break;
            }
        }
        bufferedReader.close();
        if (found) {
            return id;
        }
        else
        throw new Exception("invalied id: "+id);
    }

    public static int checkid() throws Exception
    {
        int id=App.scanner.nextInt();
        App.scanner.nextLine();
        Boolean found=false;

        File file=new File(UserService.path);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line=bufferedReader.readLine())!=null) {
                String[] arr=line.split(",");

                if(Integer.parseInt(arr[0])==id)
                {
                    found=true;
                    break;
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(found)
        return id;
        else
        throw new Exception("invalied user id: "+id);

    }

//----------------------------------------------------------------------------

    public static void printaccount()
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

    public static void getaccount()
    {
        System.out.println("enter account number");
        long id=App.scanner.nextLong();
        App.scanner.nextLine();
        Account account=null;

        File file=new File(path);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
          
            String line;

            while ((line=bufferedReader.readLine())!=null) {
                String arr[]=line.split(",");

                if(Long.parseLong(arr[0])==id)
                {
                    account=new Account(Long.parseLong(arr[0]), arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]),arr[4], Double.parseDouble(arr[5]));
                    break;
                }
            }
            System.out.println(account);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void updateaccount()
    {
        System.out.println("enter account number");
        Long id=App.scanner.nextLong();
        App.scanner.nextLine();

        File file=new File(path);
        File temp=new File("temp.txt");

        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(temp));

            String line;

            while ((line=bufferedReader.readLine())!=null) {
                
                String[] arr=line.split(",");

                if(Long.parseLong(arr[0])==id)
                {
                   System.out.println("enter option: 1 account type");
                   int option=App.scanner.nextInt();
                   App.scanner.nextLine();

                   switch (option) {
                    case 1:
                        String currenttype=arr[4];
                        System.out.println("current type: "+currenttype);
                        System.out.println("enter nuw type");
                        String newtype=App.scanner.nextLine();
                        arr[4]=newtype;
                        break;
                   
                    default:
                    throw new Exception("invalied option: "+option);
                   }

                }
                bufferedWriter.write(String.join(",", arr)+System.lineSeparator());
            }
            bufferedReader.close();
            bufferedWriter.close();
            if(!file.delete())
            {
                throw new Exception("original file is not deleted");
            }
            if(!temp.renameTo(file))
            {
                throw new Exception("original file is not rename to temp file");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void deleteaccount()
    {
        System.out.println("enter account number");
        Long id=App.scanner.nextLong();
        App.scanner.nextLine();

        File file=new File(path);
        File temp=new File("temp.txt");

        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(temp));

            String line;

            while ((line=bufferedReader.readLine())!=null) {
                String arr[]=line.split(",");

                if(Long.parseLong(arr[0])==id)
                {
                    continue;
                }
                bufferedWriter.write(line+System.lineSeparator());
            }
            bufferedReader.close();
            bufferedWriter.close();

            if(!file.delete())
            {
                throw new Exception("original file is not deleted");

            }
            if(!temp.renameTo(file))
            {
                throw new Exception("original file is not rename to temp file");

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }

    //------------------------------------------------------------------------


    public static void whithdrawel()
    {
        System.out.println("enter account number");
        Long id=App.scanner.nextLong();
        App.scanner.nextLine();

        File file=new File(path);
        File temp=new File("temp.txt");

        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(temp));

            String line;

            while ((line=bufferedReader.readLine())!=null) {
                String[] arr=line.split(",");

                if(Long.parseLong(arr[0])==id)
                {
                    System.out.println("enter whithdrawel amount");
                    double amount=App.scanner.nextDouble();
                    App.scanner.nextLine();

                    double currentamount=Double.parseDouble(arr[5]);
                    if(currentamount>amount)
                    {
                        arr[5]=String.valueOf(currentamount-amount);
                        System.out.println("whithdrawel amount successfully :"+amount);
                    }
                    else
                    System.out.println("insuficient balance: "+currentamount);
                    

                }
                bufferedWriter.write(String.join(",", arr)+System.lineSeparator());
            }
            bufferedReader.close();
            bufferedWriter.close();
            if(!file.delete())
            {
                throw new Exception("original file is not deleted");
            }
            if(!temp.renameTo(file))
            {
                throw new Exception("original file is not rename to temp file");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void depositamount()
    {
        System.out.println("enter account number");
        Long id=App.scanner.nextLong();
        App.scanner.nextLine();

        File file=new File(path);
        File temp=new File("temp.txt");

        try {

            BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(temp));

            String line;

            while ((line=bufferedReader.readLine())!=null) {
                
                String[] arr=line.split(",");

                if(Long.parseLong(arr[0])==id)
                {
                    double currentamount=Double.parseDouble(arr[5]);
                    System.out.println("current balance: "+currentamount);

                    System.out.println("enter deposit amount");
                    double amount=App.scanner.nextDouble();
                    App.scanner.nextLine();

                    double newamount=currentamount+amount;
                    arr[5]=String.valueOf(newamount);
                    System.out.println("deposit amount successfully: "+amount);
                }
                bufferedWriter.write(String.join(",", arr)+System.lineSeparator());
            }
            bufferedReader.close();
            bufferedWriter.close();
            if(!file.delete())
            {
                throw new Exception("original file is not deleted");
            }
            if(!temp.renameTo(file))
            {
                throw new Exception("original file is not rename to temp file");
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void checkbalance()
    {
        System.out.println("enter account number");
        Long id=App.scanner.nextLong();
        App.scanner.nextLine();

        File file=new File(path);
        try {
            
            BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            String line;

            while ((line=bufferedReader.readLine())!=null) {
                String[] arr=line.split(",");

                if(Long.parseLong(arr[0])==id)
                {
                    double balance=Double.parseDouble(arr[5]);
                    System.out.println("current balance: "+balance);
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
