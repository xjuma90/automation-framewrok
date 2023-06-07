import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import pages.ReportPortalLandingPage;
import pages.ReportPortalLogInPage;
import utils.FrameworkProperties;


public class Main {
    public static void main(String[] args) {
        FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton driverSingleton = DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        WebDriver driver = DriverSingleton.getDriver();

        driver.get("https://rp.epam.com");


        ReportPortalLandingPage reportPortalLandingPage  = new ReportPortalLandingPage();
        ReportPortalLogInPage reportPortalLogInPage =new ReportPortalLogInPage();

        reportPortalLogInPage.validateRPLoginIsDisplay();
        reportPortalLogInPage.fillLogInCredetials(frameworkProperties.getProperty("email"),frameworkProperties.getProperty("password"));
        reportPortalLandingPage.validateRPLandingPage();
    }
}
