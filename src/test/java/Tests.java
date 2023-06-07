import com.google.common.annotations.VisibleForTesting;
import driver.DriverSingleton;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ReportPortalLandingPage;
import pages.ReportPortalLogInPage;
import utils.Constans;
import utils.FrameworkProperties;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Tests {
    static FrameworkProperties frameworkProperties;
    static WebDriver driver;
    static ReportPortalLogInPage reportPortalLogInPage;
    static  ReportPortalLandingPage reportPortalLandingPage;

    @BeforeClass
    public static void initializeBrowser(){
        frameworkProperties = new FrameworkProperties();
        DriverSingleton.getInstance(frameworkProperties.getProperty(Constans.BROWSER));
        driver = DriverSingleton.getDriver();
        reportPortalLandingPage = new ReportPortalLandingPage();
        reportPortalLogInPage = new ReportPortalLogInPage();

    }

    @Test
    public void testingLogInPage(){
        driver.get(Constans.URL);
        String text = reportPortalLogInPage.validateRPLoginIsDisplay();
        assertTrue(text.contains("Welcome"));
    }

    @Test
    public void testingAuthentication(){
        driver.get(Constans.URL);
        reportPortalLogInPage.fillLogInCredetials(frameworkProperties.getProperty(Constans.EMAIL), frameworkProperties.getProperty(Constans.PASSWORD));
        assertEquals("JL",reportPortalLandingPage.validateRPLandingPage());
    }

    @AfterClass
    public static void closeObject(){
        driver.quit();
    }

}
