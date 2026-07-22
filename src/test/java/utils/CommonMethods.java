package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class CommonMethods extends pageInitialiser {

    public static WebDriver driver;

    public void openBrowserAndLaunchApplication() {

        String browser = ConfigReader.read("browser");

        if (browser == null) {
            throw new RuntimeException(
                    "The 'browser' property is missing from config.properties"
            );
        }

        switch (browser.toLowerCase()) {

            case "chrome":

                ChromeOptions options = new ChromeOptions();

                String headlessValue = ConfigReader.read("headless");
                boolean headless =
                        Boolean.parseBoolean(headlessValue);

                if (headless) {
                    options.addArguments("--headless=new");
                    options.addArguments("--window-size=1920,1080");
                }

                // Important for Jenkins/Linux/Docker
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
                options.addArguments("--remote-allow-origins=*");

                driver = new ChromeDriver(options);
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            case "safari":
                driver = new SafariDriver();
                break;

            default:
                throw new RuntimeException(
                        "Invalid browser name: " + browser
                );
        }

        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(20));

        if (!Boolean.parseBoolean(ConfigReader.read("headless"))) {
            driver.manage().window().maximize();
        }

        driver.get(ConfigReader.read("url"));

        // Initializes LoginPage, AddEmployee, etc.
        initilizePageObjects();
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public void sendText(String text, WebElement element) {

        if (text == null) {
            throw new IllegalArgumentException(
                    "Text is null. Check the key in config.properties."
            );
        }

        element.clear();
        element.sendKeys(text);
    }

    public void selectFromDropDown(
            WebElement dropDown,
            String visibleText
    ) {
        Select select = new Select(dropDown);
        select.selectByVisibleText(visibleText);
    }

    public void selectFromDropDown(
            String value,
            WebElement dropDown
    ) {
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }

    public void selectFromDropDown(
            WebElement dropDown,
            int index
    ) {
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }

    public WebDriverWait getWait() {
        return new WebDriverWait(
                driver,
                Duration.ofSeconds(Constants.EXPLICIT_WAIT)
        );
    }

    public void waitForElementToBeClickAble(WebElement element) {
        getWait().until(
                ExpectedConditions.elementToBeClickable(element)
        );
    }

    public void click(WebElement element) {
        waitForElementToBeClickAble(element);
        element.click();
    }

    public JavascriptExecutor getJSExecutor() {
        return (JavascriptExecutor) driver;
    }

    public void jsClick(WebElement element) {
        getJSExecutor().executeScript(
                "arguments[0].click();",
                element
        );
    }

    public byte[] takeScreenshot(String fileName) {

        TakesScreenshot screenshot =
                (TakesScreenshot) driver;

        byte[] picture =
                screenshot.getScreenshotAs(OutputType.BYTES);

        File sourceFile =
                screenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(
                    sourceFile,
                    new File(
                            Constants.SCREENSHOT_FILEPATH
                                    + fileName
                                    + " "
                                    + getTimeStamp(
                                    "yyyy-MM-dd-HH-mm-ss"
                            )
                                    + ".png"
                    )
            );
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return picture;
    }

    public String getTimeStamp(String pattern) {
        return new SimpleDateFormat(pattern)
                .format(new Date());
    }
}