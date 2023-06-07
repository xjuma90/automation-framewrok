package driver.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
public class PhantomJS implements  DriverStrategy{
    public WebDriver setStrategy() {
        System.setProperty("phantomjs.binary.path", "src/main/resources/phantomjs.exe");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setJavascriptEnabled(true);
        WebDriver driver = new PhantomJSDriver(desiredCapabilities);

        return driver;
    }
}
