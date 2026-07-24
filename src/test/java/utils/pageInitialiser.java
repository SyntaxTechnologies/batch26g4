package utils;

import pages.*;

public class pageInitialiser {

    public static LoginPage loginPage;
    public static AddEmployee addEmployee;
    public static EmployeeSearchPage employeeSearchPage;
    public static ChangePersonalDetailsPage changePersonalDetailsPage;
    public static ChangeContactDetailsPage changeContactDetailsPage;

    /*public  static CreateEmployeeLoginPage createEmployeeLoginPage;
    public static EditContactDetailsPage editContactDetailsPage;
    public static EmployeeSearchPage employeeSearchPage;
    public static EditPersonalDetailsPage editPersonalDetailsPage;

     */

    public static void initilizePageObjects() {
        loginPage = new LoginPage();
        addEmployee=new AddEmployee();
        employeeSearchPage = new EmployeeSearchPage();
        changePersonalDetailsPage  = new ChangePersonalDetailsPage();
        changeContactDetailsPage = new ChangeContactDetailsPage();
       /*
        editContactDetailsPage=new EditContactDetailsPage();
        employeeSearchPage = new EmployeeSearchPage();
        createEmployeeLoginPage = new CreateEmployeeLoginPage();
        editPersonalDetailsPage = new EditPersonalDetailsPage();

        */
    }
}