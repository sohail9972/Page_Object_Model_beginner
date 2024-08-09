package TestingZulri;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class TestCase1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(10);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        driver.get("https://www.amazon.in/");
        try {
            long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

            while (true) {
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
                Thread.sleep(2000);

                long newHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
                if (newHeight == lastHeight) {
                    break;
                }
                lastHeight = newHeight;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        WebElement elementRef = driver.findElement(By.xpath("//div[@class='rhf-sign-in-title']"));
//        elementRef.isDisplayed();
        WebElement button = driver.findElement(By.xpath("//a[@class='action-button']"));
        Actions at = new Actions(driver);
//        if(elementRef.isDisplayed() && button.isDisplayed()){
//            at.moveToElement(button).perform();
//            button.click();
//        }

//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("window.scrollBy(0,600)", button);




        if (button.isDisplayed()){
            button.isEnabled();
            at.moveToElement(button).perform();
            button.click();

        }
        driver.findElement(By.name("email")).sendKeys("zulri@Test.com");
        driver.findElement(By.id("continue")).click();
    }

}
