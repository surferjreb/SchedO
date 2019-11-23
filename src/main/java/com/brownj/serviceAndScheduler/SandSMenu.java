package com.brownj.serviceAndScheduler;

public class SandSMenu {
    private static SandSMenu mySanSMenu = null;
    private Schedule theSchedule;
    private Service myService;

    private SandSMenu(){
        System.out.println("Service and Schedule Menu Created...");
        theSchedule = new Schedule();
        myService= new Service();

        System.out.println("Welcome to the Service And Scheduler Menu!");
    }

    public static SandSMenu getInstance(){
        if(mySanSMenu == null){
            mySanSMenu = new SandSMenu();
        }

        return mySanSMenu;
    }

}
