package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import javax.xml.xpath.XPath;
import java.util.List;

public class ChangePersonalDetailsPage extends CommonMethods {


    @FindBy(xpath = "(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[3]")
    public WebElement MyInfoOption;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='middleName']")
    public WebElement middleName;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastName;

    @FindBy(xpath = "(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[2]") // Male
    public WebElement genderFemale;

    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")
    public WebElement nationalityDropdown;

    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")
    public WebElement maritalStatusDropdown;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    public ChangePersonalDetailsPage() {
        //the code we write will be automatically called when you create an object
        //page factory we use to initialise all the elements we use from selenium and the driver is coming from cm
        PageFactory.initElements(driver, this);


    }
}