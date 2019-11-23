package com.brownj.customer;

import java.util.Random;

public class Customer {
    private Random rand;
    private final int CUS_MAX_INDEX = 1000;

//Customer attributes
    private String cusId;
    private String fName;
    private String lName;
    private String emailAddress;
    private String phNumber;
    private String address;
    private String city;
    private String state;
    private String zipCode;

    public Customer(){
        System.out.println("Customer object Created");
        rand = new Random();
    }

    public void addCustomer(String cusId, String fName, String lName, String emailAddress,
                             String phNumber, String address, String city,
                             String state, String zipCode){
        this.cusId = cusId;
        this.fName = fName;
        this.lName = lName;
        this.emailAddress = emailAddress;
        this.phNumber = phNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;

    }
//------------------------------------------------------

//------------------------------------------------------
    public int generateCusID(){
        int newCusId = rand.nextInt(CUS_MAX_INDEX);

        if(checkCusId(newCusId))
            return newCusId;

        return -1;
    }
//------------------------------------------------------
    private boolean checkCusId(int newCusId){
        CustomerList myCusList = CustomerList.getInstance();

        for(int i = 0; i < myCusList.getArrayListSize(); i++){
            Customer myCurrentCustomer = myCusList.getMyCusListItem(i);
            int checkId = Integer.parseInt(myCurrentCustomer.getCusID());

            if(checkId == newCusId){
                generateCusID();
                break;
            }

        }

        return true;

    }//End checkCusId
//------------------------------------------------------
    private String getCusID(){
        return cusId;
    }//end getCusId
//------------------------------------------------------
    public String getCusId() {
        return cusId;
    }
//------------------------------------------------------
    public String getfName() {
        return fName;
    }
//------------------------------------------------------
    public String getlName() {
        return lName;
    }
//------------------------------------------------------
    public String getEmailAddress() {
        return emailAddress;
    }
//------------------------------------------------------
    public String getPhNumber() {
        return phNumber;
    }
//------------------------------------------------------
    public String getAddress() {
        return address;
    }
//------------------------------------------------------
    public String getCity() {
        return city;
    }
//------------------------------------------------------
    public String getState() {
        return state;
    }
//------------------------------------------------------
    public String getZipCode() {
        return zipCode;
    }
//------------------------------------------------------

}//end Class
