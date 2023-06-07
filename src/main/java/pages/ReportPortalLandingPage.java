package pages;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReportPortalLandingPage {

    private WebDriver driver;
    public ReportPortalLandingPage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(css ="div.sidebar__bottom-block--3EH2A")
    private WebElement sideBarBottomBlock;
    @FindBy(css ="div.projectSelector__current-project-name--vz3i6")
    private WebElement userName;
    public  String validateRPLandingPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(userName));
        //Assertion here
        return userName.getText();
    }
}
