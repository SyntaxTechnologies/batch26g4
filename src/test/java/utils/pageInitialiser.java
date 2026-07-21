package utils;

import pages.AddEmployee;
import pages.LoginPage;

public class pageInitialiser {

    public static LoginPage loginPage;
    public static AddEmployee addEmployee;

    /*public  static CreateEmployeeLoginPage createEmployeeLoginPage;
    public static EditContactDetailsPage editContactDetailsPage;
    public static EmployeeSearchPage employeeSearchPage;
    public static EditPersonalDetailsPage editPersonalDetailsPage;

     */

    public static void initilizePageObjects() {
        loginPage = new LoginPage();
        addEmployee=new AddEmployee();
       /*
        editContactDetailsPage=new EditContactDetailsPage();
        employeeSearchPage = new EmployeeSearchPage();
        createEmployeeLoginPage = new CreateEmployeeLoginPage();
        editPersonalDetailsPage = new EditPersonalDetailsPage();

        */
    }
}
