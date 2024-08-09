package TestingDataFromExcelonWebDriver;

import DataGenerators.DataGeneratorsAutomation;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Test1 {


    @Test(dataProvider = "Excel",dataProviderClass = DataGeneratorsAutomation.class)
    public void testing(String useName,String pass){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

//        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(useName);

//        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys(pass);

        driver.findElement(By.name("login")).click();

    }

}