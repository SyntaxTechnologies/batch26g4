package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class EmployeeSearchPage extends CommonMethods {

    @FindBy(xpath = "(//div[@class='oxd-table-cell oxd-padding-cell'])[4]")
    public WebElement lastNameCell;

    @FindBy(xpath = "//label[text()='Employee Id']/parent::div/following-sibling::div//input")
    public WebElement empIdSearchField;

    @FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
    public WebElement empNameSearchField;

    @FindBy(xpath = "//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    public WebElement searchButton;

    @FindBy(xpath = "(//div[@class='oxd-table-cell oxd-padding-cell'])[3]")
    public WebElement firstNameCell;

    @FindBy(xpath = "(//div[@class='oxd-table-cell oxd-padding-cell'])[2]")
    public WebElement IDCell;

    @FindBy(xpath = "(//span[@class='oxd-text oxd-text--span'])[1]")
    public WebElement ErrorMessageCell;

    public EmployeeSearchPage() {
        //the code we write will be automatically called when you create an object
        //page factory we use to initialise all the elements we use from selenium and the driver is coming from cm
        PageFactory.initElements(driver, this);
    }

}
