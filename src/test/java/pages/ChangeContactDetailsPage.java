package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class ChangeContactDetailsPage extends CommonMethods {

    @FindBy(xpath = "(//a[@class='orangehrm-tabs-item'])[1]")
    public WebElement contactDetailsOption;

    @FindBy(xpath = "//label[text()='Street 1']/parent::div/following-sibling::div//input")
    public WebElement street1;

    @FindBy(xpath = "//label[text()='Street 2']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public WebElement street2;

    @FindBy(xpath = "//label[text()='City']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public WebElement cityLocator;

    @FindBy(xpath = "//label[text()='State/Province']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public WebElement stateLocator;

    @FindBy(xpath = "//label[text()='Zip/Postal Code']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public WebElement zipCodeLocator;

    @FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
    public WebElement countryDropdown;

    @FindBy(xpath = "//label[text()='Home']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public WebElement homePhone;

    @FindBy(xpath = "//label[text()='Mobile']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public WebElement mobilePhone;

    @FindBy(xpath = "//label[text()='Work']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public WebElement workPhone;

    @FindBy(xpath = "//label[text()='Work Email']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public WebElement workEmail;

    @FindBy(xpath = "//label[text()='Other Email']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public WebElement otherEmail;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    public ChangeContactDetailsPage() {
        PageFactory.initElements(driver, this);
    }
}
