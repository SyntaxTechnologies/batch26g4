package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameLoc;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordLoc;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginBtn;

    @FindBy(xpath="//h6[text()='Dashboard']")
    public WebElement dashboardText;

    @FindBy(xpath = "//p[text()='Invalid credentials']")
    public WebElement errorPasswordText;

    @FindBy(xpath = "//input[@name='username']/ancestor::div[contains(@class,'oxd-input-group')]//span")
    public WebElement usernameRequiredText;

    @FindBy(xpath = "//input[@name='password']/ancestor::div[contains(@class,'oxd-input-group')]//span")
    public WebElement passwordRequiredText;



    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
}
