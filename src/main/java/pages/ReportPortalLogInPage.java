package pages;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReportPortalLogInPage {
    private WebDriver driver;
    public ReportPortalLogInPage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(css ="input.inputOutside__input--1Sg9p[placeholder='Login']")
    private WebElement nameBox;
    @FindBy(css ="input.inputOutside__input--1Sg9p[placeholder='Password']")
    private WebElement passwordBox;
    @FindBy(css ="div.loginForm__login-button-container--1mHGW>button")
    private WebElement siginBtn;
    @FindBy(css ="span.blockHeader__block-header--AHdxL>span")
    private WebElement welcomeText;

    public String validateRPLoginIsDisplay(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(welcomeText));
        String text =welcomeText.getText();
        return text;
    }
    public void fillLogInCredetials(String name, String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(nameBox));
        nameBox.sendKeys(name);
        passwordBox.sendKeys(password);
        siginBtn.click();

    }




}
