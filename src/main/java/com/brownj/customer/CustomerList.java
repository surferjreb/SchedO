package com.brownj.customer;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerList {
    private static CustomerList myCustomers = null;
    private Customer myCustomer;
    private ArrayList<Customer> myCusList;

    private CustomerList(){
        myCusList =new ArrayList<Customer>();
        System.out.println("Customer list created");
    }

    public static CustomerList getInstance(){
        if(myCustomers == null){
            myCustomers = new CustomerList();
        }

        return myCustomers;
    }//end getInstance

    public ArrayList getMyCusList(){
        return myCusList;
    }

    public int getArrayListSize(){
        int size = myCusList.size();

        return size;
    }

    public Customer getMyCusListItem(int index){

        return myCusList.get(index);
    }

    public void addNewCustomerToList(Customer myCustomer){
        myCusList.add(myCustomer);
    }//end addNewCustomerToList
//---------------------------------------------------------------
    public void addNewCustomer(){
        myCustomer = new Customer();

        String cusId = String.valueOf(myCustomer.generateCusID());
        String fName;
        String lName;
        String emailAddress;
        String phNumber;
        String address;
        String city;
        String state;
        String zipCode;
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Please enter customer information..");
            System.out.println();

            System.out.print("Enter Customer First Name: ");
            fName = input.nextLine();
            System.out.println();
            System.out.print("Enter Customer Last Name: ");
            lName = input.nextLine();
            System.out.println();
            System.out.print("Enter Customer Email address: ");
            emailAddress = input.nextLine();
            System.out.println();
            System.out.print("Enter Customer Phone Number: ");
            phNumber = input.nextLine();
            System.out.println();
            System.out.print("Enter Customer address: ");
            address = input.nextLine();
            System.out.println();
            System.out.print("Enter Customer city: ");
            city = input.nextLine();
            System.out.println();
            System.out.print("Enter Customer state: ");
            state = input.nextLine();
            System.out.println();
            System.out.print("Enter Customer zip code: ");
            zipCode = input.nextLine();
            System.out.println();


            myCustomer.addCustomer(cusId, fName, lName, emailAddress, phNumber,
                address, city, state, zipCode);

            addNewCustomerToList(myCustomer);
    }
    catch (Exception e){
        e.printStackTrace();
    }
}//end AddNewCustomer
//---------------------------------------------------------------
    public Customer getCustomerFromList(int index){
        return myCusList.get(index);
    }
}//end Class
