package com.brownj.customer;

import com.brownj.Menu;

import java.util.Scanner;

public class CustomerMenu {
    private static CustomerMenu myCusMenu = null;
    private CustomerList myCusList;
    private Menu myMenu;

    private CustomerMenu(){
        //System.out.println("Customer menu created...");
        myCusList = CustomerList.getInstance();
    }//end constructor
//------------------------------------------------------------------
    public static CustomerMenu getInstance(){
        if(myCusMenu == null){
            myCusMenu = new CustomerMenu();
        }

        return myCusMenu;
    }//end getInstance
//------------------------------------------------------------------
    private void addCustomer(){
        try {
            myCusList.addNewCustomer();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }// end addCustomer
//------------------------------------------------------------------
    private void printCustomerList(){
        System.out.println("CusID\tFirst Name\tLast Name\tEmail\tPhone Number\tAddress\t\tCity\tState\tZip Code");
        for(int i = 0; i < myCusList.getArrayListSize(); i++) {
            Customer myCustomer = myCusList.getMyCusListItem(i);
            System.out.print(myCustomer.getCusId()+"\t\t"+myCustomer.getfName()+"\t"+
                    myCustomer.getlName()+"\t"+ myCustomer.getEmailAddress()+"\t"+
                    myCustomer.getPhNumber()+"\t"+myCustomer.getAddress()+"\t"+
                    myCustomer.getCity()+"\t"+myCustomer.getState()+"\t"+
                    myCustomer.getZipCode()+"\n");

        }

    }//end print
//------------------------------------------------------------------
    private void printMenu(){
        System.out.println("\t***Welcome To The Customer Menu***");
        System.out.println("\t\t1.\tAdd Customer.");
        System.out.println("\t\t2.\tPrint Customer List.");
        System.out.println("\t\t5.\tTo quit and return to the previous menu.");
    }
//------------------------------------------------------------------
    public void runCustomerMenu(){
        boolean quit = false;
        myMenu = new Menu();

        menu();


    }
//------------------------------------------------------------------
    private boolean menu() {
        Scanner input = new Scanner(System.in);
        int selection;
        boolean quit = false;


            try {
                while (!quit) {
                printMenu();
                System.out.print("Enter your selection: ");
                selection = input.nextInt();
                switch (selection) {
                    case 1:
                        addCustomer();
                        break;
                    case 2:
                       // addMultipleCustomers();
                        break;
                    case 3:
                        printCustomerList();
                        break;
                    case 5:
                        System.out.println("Good Bye!");
                        quit = true;
                        break;
                    default:
                        System.out.println("Your \"selection\" " + selection + " is not on the menu.");
                        System.out.println("Please try again");
                }
                }//end while
            } catch (Exception e) {
                e.printStackTrace();
            }//end tryCatch

            return quit;
    }//end menu
//-----------------------------------------------------------------
}//end class
