package Basefile;
import io.github.bonigarcia.wdm.WebDriverManager;
import automation.testingworld.utility.utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class DriverInstance {
    public WebDriver driver;
    @BeforeMethod
    public void initiaateDriverInstance() throws IOException {
        if (utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.get(utility.fetchPropertyValue("applicationURL").toString());

    }
//    similary we can do it for other Browsers

    @AfterMethod
    public void closeDriverInstance(){
        driver.quit();

    }
}
