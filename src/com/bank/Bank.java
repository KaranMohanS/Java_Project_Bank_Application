package com.bank;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

import com.App;
import com.atm.Atm;
import com.branch.Branch;

public class Bank {
     
    public static List<Bank> banks=new ArrayList<>();
   
    public static List<Branch> list=new ArrayList<>();

    public static List<Atm> atms=new ArrayList<>();


    public static void addbranch() throws Exception
    {
      System.out.println("enter branch id");
      int id=App.scanner.nextInt();
      App.scanner.nextLine();

      System.out.println("enter branch address");
      String add=App.scanner.nextLine();

      System.out.println("enter bank id");
      int bank_id=checkid();

      Branch branch=new Branch(id, add, bank_id);
      addbranch(branch);
    }

    public static void addbranch(Branch branch)
    {
      int id=list.size()+1;
      branch.setBranch_id(id);
      list.add(branch);
    }

    public static int checkid() throws Exception
    {
        int id=App.scanner.nextInt();
        App.scanner.nextLine();
        boolean fount=false;
        for(Bank x:banks)
        {
        if(x.getBank_id()==id)
        {
            fount=true;
            
        }
    }
        if(fount)
        {
            return id;
        }
        else
        {
            throw new Exception("invalid bank id: "+id);
        }
    }
//------------------------------------------------------------------------------

    public static void printbranch()
    {
        for(Branch x:list)
        {
            System.out.println(x);
        }
    }
//------------------------------------------------------------------------------

   public static void getbranch()
   {
     System.out.println("enter branch id");
     int id=App.scanner.nextInt();
     App.scanner.nextLine();

     for(Branch x:list)
     {
        if(x.getBranch_id()==id)
        {
            System.out.println(x);
            break;
        }
     }

   }

   //----------------------------------------------------------------

   public static void updatebranch()
   {
     System.out.println("enter branch id");
     int id=App.scanner.nextInt();

     App.scanner.nextLine();
     System.out.println("enter option: 1 address ");
     int option=App.scanner.nextInt();
     App.scanner.nextLine();

     switch (option) {
        case 1:
            System.out.println("enter new address");
            String bid=App.scanner.nextLine();
            
            for(Branch x:list)
            {
                if(x.getBranch_id()==id)
                {
                    x.setAddress(bid);
                    break;
                }
            }
            break;
     
        default:
            break;
     }
   }
   //----------------------------------------------------------------------------------

   public static void deletebranch()
   {
    System.out.println("enter branch id ");
    int id=App.scanner.nextInt();
    App.scanner.nextLine();

    for(Branch x:list)
    {
        if(x.getBranch_id()==id)
        {
            list.remove(x);
            break;
        }
    }
   }

//-----------------------------------------------------------------------------------------

   public static void addatm() throws EOFException
   {
    System.out.println("enter atm id");
    int id=App.scanner.nextInt();
    App.scanner.nextLine();

    System.out.println("enter address");
    String add=App.scanner.nextLine();

    System.out.println("enter bank id");
    int bid=checkbid();

    Atm atm=new Atm(id, add, bid);
    addatm(atm);
   }
   
   public static void addatm(Atm atm)
   {
      int id=atms.size()+1;
      atm.setAtm_id(id);
      atms.add(atm);
   }


   public static int checkbid() throws EOFException
   {
    int bid=App.scanner.nextInt();
    App.scanner.nextLine();
    boolean found=false;

     for(Bank x:banks)
     {
        if(x.getBank_id()==bid)
        {
            found=true;
        }
     }
     if(found)
     {
        return bid;
     }
     else
     {
        throw new EOFException("invalied bank id: "+bid);
     }
   }

//-----------------------------------------------------------------------------


  public static void removeatm()
  {
    System.out.println("enter atm id");
    int id=App.scanner.nextInt();
    App.scanner.nextLine();

    for(Atm x:atms)
    {
        if(x.getAtm_id()==id)
        {
            atms.remove(x);
            break;
        }
    }
  }

  public static void getatm()
  {
    System.out.println("enter atm id");
    int id=App.scanner.nextInt();
    App.scanner.nextLine();

    for(Atm x:atms)
    {
        if(x.getAtm_id()==id)
        {
            System.out.println(x);
            break;
        }
    }
  }

  public static void updateatm()
  {
    System.out.println("enter atm id");
    int id=App.scanner.nextInt();
    App.scanner.nextLine();

    for(Atm x:atms)
    {
        if(x.getAtm_id()==id)
        {
            System.out.println("enter option: 1 address");
            int option=App.scanner.nextInt();
            App.scanner.nextLine();

            switch (option) {
                case 1:
                    
                    System.out.println("enter new address");
                    String newadd=App.scanner.nextLine();
                    x.setAddress(newadd);
                    break;
            
                default:
                    System.out.println("invalied option: "+option);
                    break;
            }

        }
    }
  }

  public static void printatm()
  {
    for(Atm x:atms)
    {
        System.out.println(x);
    }
  }

//------------------------------------------------------






     int bank_id=1;
     String bank_name=" CANARA ";
     String address=" Mettupalayam ";
   





    public int getBank_id() {
        return bank_id;
    }

    public void setid(int id)
    {
        this.bank_id=id;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setname(String name)
    {
        this.bank_name=name;
    }

    public String getAddress() {
        return address;
    }

    public void setadd(String add)
    {
        this.address=add;
    }




    

    

}
