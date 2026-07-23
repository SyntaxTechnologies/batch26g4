package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployee extends CommonMethods {

    @FindBy(xpath = "//a[.//span[text()='PIM']]")
    public WebElement pimOption;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    public WebElement addButton;

    @FindBy(name = "firstName")
    public WebElement firstNameLoc;

    @FindBy(name = "middleName")
    public WebElement middleNameLoc;

    @FindBy(name = "lastName")
    public WebElement lastNameLoc;

    @FindBy(xpath = "(//input[contains(@class,'oxd-input')])[5]")
    public WebElement employeeIdLoc;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//h6[normalize-space()='Personal Details']")
    public WebElement personalDetailsHeader;

    @FindBy(xpath = "//span[text()='Required']")
    public WebElement requiredText;

    public AddEmployee() {
        PageFactory.initElements(driver, this);
    }




}
