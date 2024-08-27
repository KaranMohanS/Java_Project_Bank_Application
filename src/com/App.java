package com;

import com.Login.LoginService;
import com.account.Account;
import com.account.AccountJdbc;
import com.account.AccountService;
import com.bank.Bank;
import com.bank.BankJdbc;
import com.branch.Branch;
import com.branch.BranchJdbc;
import com.branch.BranchService;
import com.user.User;
import com.user.UserService;
import com.user.Userjdbc;

import java.util.Scanner;

public class App {

      public static Scanner scanner = new Scanner(System.in);

      public static void main(String[] args) throws Exception {
            System.out.println("Hello, World!");

          /*   while (true) {

                  int user_input = 1;

                  while (user_input == 1) {
                        System.out.println("enter user input");
                        user_input = scanner.nextInt();
                        scanner.nextLine();

                        if (user_input == 1) {
                              System.out.println(
                                          "enter bank option: 1 user details | 2 add  branch | 3 add account | 4 whithdrawel | 5 Deposit amount | 6 check balance | 7 exit");
                              int option = scanner.nextInt();
                              scanner.nextLine();

                              switch (option) {
                                    case 1:
                                          System.out.println(
                                                      "enter option: 1 add user details | 2 update details | 3 get details | 4 delete details | 5 print branch | 6 exit");
                                          int option1 = scanner.nextInt();
                                          scanner.nextLine();

                                          switch (option1) {
                                                case 1:
                                                      UserService.adduser();
                                                      break;
                                                case 2:
                                                      UserService.updateuser();
                                                      break;

                                                case 3:

                                                      UserService.getuser();
                                                      break;

                                                case 4:

                                                      UserService.deleteuser();
                                                      break;

                                                case 5:

                                                      UserService.printuser();
                                                      break;

                                                case 6:

                                                      break;

                                                default:
                                                      throw new Exception("invalied option: " + option1);
                                          }

                                          break;

                                    case 2:

                                          System.out.println(
                                                      "enter branch option: 1 add branch | 2 update branch | 3 get branch | 4 delete branch | 5 print branch | 6 exit");
                                          int option2 = scanner.nextInt();
                                          scanner.nextLine();

                                          switch (option2) {
                                                case 1:

                                                      BranchService.addbranch();

                                                      break;
                                                case 2:

                                                      BranchService.updatebranch();
                                                      break;

                                                case 3:

                                                      BranchService.getbranch();
                                                      break;

                                                case 4:

                                                      BranchService.deletebranch();
                                                      break;

                                                case 5:

                                                      BranchService.printbranch();
                                                      break;

                                                case 6:

                                                      break;

                                                default:
                                                      throw new Exception("invalied option: " + option2);
                                          }

                                    case 3:

                                          System.out.println(
                                                      "enter account option: 1 add account | 2 update account | 3 get account | 4 delete account | 5 print account | 6 exit");
                                          int option3 = scanner.nextInt();
                                          scanner.nextLine();

                                          switch (option3) {
                                                case 1:

                                                      AccountService.addaccount();
                                                      break;

                                                case 2:

                                                      AccountService.updateaccount();
                                                      break;

                                                case 3:

                                                      AccountService.getaccount();
                                                      break;
                                                case 4:
userInput
                                                      AccountService.deleteaccount();
                                                      break;

                                                case 5:

                                                      AccountService.printaccount();
                                                      break;

                                                default:
                                                      throw new Exception("invalied option" + option3);
                                          }

                                    case 4:
                                         
                                         AccountService.whithdrawel();
                                         break;

                                    case 5:
                                         
                                         AccountService.depositamount();
                                         break;

                                    case 6:
                                        
                                         AccountService.checkbalance();
                                         break;
                                    
                                    case 7:
`
                                         break;

                                    default:
                                          break;
                              }
                        } else
                              break;
                  }
            }*/

            Boolean found=true;
            while (found) {

                  int userInput=1;

                  while (userInput==1) {
                        System.out.println("enter option: 1  ");
                        userInput=App.scanner.nextInt();
                        App.scanner.nextLine();
                        
                        if(userInput==1)
                        {
                           System.out.println("Enter Option: 1 Login | 2 Create Account | 3 exit");
                           int option=App.scanner.nextInt();
                           App.scanner.nextLine();
                           if(option==1)
                           {
                              System.out.println("Enter option: 1 User Login | 2 Employee Login");
                              {
                                    int option1=App.scanner.nextInt();
                                    App.scanner.nextLine();

                                    if(option1==1)
                                    {
                                      if(LoginService.Loginaccess())
                                      {
                                          System.out.println("--- User Login Successfully ---");
                                          useroperation();
                                      }
                                      else
                                      {
                                          System.out.println("--- Invalid Data ---");
                                          userInput=0;
                                      }
                                    }
                                    else if(option1==2)
                                    {
                                       if(LoginService.Loginaccess())
                                       {
                                          System.out.println("--- Empolyee Login Successfully ---");

                                       }
                                       else
                                       {
                                          System.out.println("--- Invalid Data ---");                                         

                                       }
                                    }
                                    else
                                    {
                                          System.out.println("invalid option: "+option1);
                                          userInput=0;
                                    }
                              }
                           }
                           else if(option==2)
                           {
                              LoginService.createaccount();
                           }
                           else
                           {
                              userInput=0;
                           }
                          
                        }
                        else
                        found=false;
                  }



            }

      }


      public static void useroperation()
      {
         
            System.out.println("enter option: 1 deposit | 2 whitdrawel | 3 money transfer | 4 check balance");
            int option=App.scanner.nextInt();
            App.scanner.nextLine();

            switch (option) {
                  case 1:
                        AccountJdbc.deposit();useroperation();
                        break;

                  case 2:
                        try {
                              AccountJdbc.whithdrawel();
                        } catch (Exception e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                        }useroperation();
                        break;

                  case 3:
                        
            
                  default:
                        break;
            }


      }

      public static void employeeoperation()
      {
            System.out.println("enter option: 1 add branch | 2 delete branch | 3 view branch | 4 get branch | 5 view accounts | 6 ");
      }


}
