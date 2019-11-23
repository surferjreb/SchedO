package com.brownj;
import com.brownj.customer.CustomerMenu;
import com.brownj.serviceAndScheduler.SandSMenu;

import java.util.Scanner;

public class Menu {
    private CustomerMenu myCusMenu;
    private  SandSMenu mySandSMenu;

    public Menu(){
        myCusMenu = CustomerMenu.getInstance();
        mySandSMenu = SandSMenu.getInstance();
        System.out.println("Menu created...");
    }

    public void runMenu(){
        Scanner input = new Scanner(System.in);
        int selection;
        boolean quit = false;


            try {
                while(!quit) {
                    System.out.println("\t***Welcome to Sched-O Menu***");
                    printMenu();
                    System.out.print("Please Make a selection: ");
                    selection = input.nextInt();

                    switch(selection){
                        case 1:
                                myCusMenu.runCustomerMenu();
                                break;
                        case 2:
                                System.out.println("run S and S menu");
                                break;
                        case 5:
                                quit = true;
                                break;
                        default:
                                System.out.println("That selection is not on the menu, Please try again..");
                    }//end switch

                }//end while
            } catch (Exception e) {
                e.printStackTrace();
            }//end tryCatch

    }//end runMenu
//------------------------------------------------------
    private void printMenu(){
        System.out.println("\t1.\t\tEnter Customer Menu");
        System.out.println("\t2.\t\tEnter Scheduler Menu");
        System.out.println("\t5.\t\tTo quit....");
    }
}
