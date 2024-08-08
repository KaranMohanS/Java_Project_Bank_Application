package com.branch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.App;
import com.bank.Bank;

public class BranchService {
    
    public static String path="branch.txt";


    public static void addbranch() throws Exception
    {
        System.out.println("enter branch id");
        int id=App.scanner.nextInt();
        App.scanner.nextLine();

        System.out.println("enter address");
        String address=App.scanner.nextLine();

        System.out.println("enter bank id");
        int bid=checkbid();

        Branch branch=new Branch(id, address, bid);
        addbranch(branch);

    }
    public static void addbranch(Branch branch) throws FileNotFoundException, IOException
    {
        File file=new File(path);
        FileWriter fileWriter=new FileWriter(file,true);

        fileWriter.write(branch.getBranch_id()+","+branch.getAddress()+","+branch.getBank_id()+"\n");
        fileWriter.close();
    }

    public static int checkbid() throws Exception
    {
        int id=App.scanner.nextInt();
        App.scanner.nextLine();
        
        if(id==1)
        {
            return id;
        }
        else
        {
            throw new Exception("invalied bank id: "+id);
        }
   
    }

    //--------------------------------------

    public static void printbranch()
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

    //------------------------------------------

    public static void deletebranch()
    {
        System.out.println("enter branch id");
        int id=App.scanner.nextInt();
        App.scanner.nextLine();


        File file=new File(path);
        File temp=new File("temp.txt");

        try (BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
             BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(temp))) {

                String line;
                Branch branch=null;

                while ((line=bufferedReader.readLine())!=null) {
                    String[] arr=line.split(",");

                    if(Integer.parseInt(arr[0])==id)
                    {
                        continue;
                    }
                    bufferedWriter.write(line+System.lineSeparator());

                }
            if(!file.delete())
            {
                throw new Exception("original file not delete");
            }
            if (!temp.renameTo(file)) {
                throw new Exception("temp file not rename to original file"); 
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    //--------------------------------------------------------------------------------

    public static Branch getbranch() throws NumberFormatException, IOException
    {
        System.out.println("enter branch id");
        int id=App.scanner.nextInt();
        App.scanner.nextLine();

        File file=new File(path);
        
        try (BufferedReader bufferedReader=new BufferedReader(new FileReader(file))) {
            
            String line;
            Branch branch=null;

            while ((line=bufferedReader.readLine())!=null) {
                String[] arr=line.split(",");

                if(Integer.parseInt(arr[0])==id)
                {
                    branch=new Branch(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]));
                    break;
                }
            }
            return branch;
        }
    }
    //---------------------------------------------------------

    public static void updatebranch()
    {
        System.out.println("enter branch id");
        int id=App.scanner.nextInt();
        App.scanner.nextLine();

        File file=new File(path);
        File temp=new File("temp.txt");
        
        try (BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
             BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(temp))) {

                String line;
                Branch branch=null;

                while ((line=bufferedReader.readLine())!=null) {
                    String[] arr=line.split(",");

                    if(Integer.parseInt(arr[0])==id)
                    {
                        System.out.println("enter option: 1 branch id | 2 address ");
                        int option=App.scanner.nextInt();
                        App.scanner.nextLine();

                        switch (option) {
                            case 1:
                                  System.out.println("current id: "+Integer.parseInt(arr[0]));
                                  System.out.println("enter new branch id");
                                  int bid=App.scanner.nextInt();
                                  App.scanner.nextLine();

                                  arr[0]=String.valueOf(bid);
                                break;

                            case 2:
                                 System.out.println("current address: "+arr[1]);
                                 System.out.println("enter new address");
                                 String add=App.scanner.nextLine();
                                 arr[1]=add;
                                 break;
                        
                            default:
                                break;
                        }
                        branch=new Branch(Integer.parseInt(arr[0]), arr[1],Integer.parseInt(arr[2]));
                    }
                    bufferedWriter.write(String.join(",",arr)+System.lineSeparator());
                }
                if(!file.delete())
                {
                    throw new Exception("original file not delete");
                }
                if (!temp.renameTo(file)) {
                    throw new Exception("temp file not rename to original file"); 
                }
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
}
