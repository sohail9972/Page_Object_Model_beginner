package JavaFakerLibrary;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EmployeeRegistration {
    EmployeeMain employee = new EmployeeMain();

    @BeforeTest
    public void generateData(){
        Faker fakeDate = new Faker();
            employee.setFirstName(fakeDate.name().firstName());
            employee.setLastName(fakeDate.name().lastName());
            employee.setInterest(fakeDate.internet().domainName());
            employee.setPhoneNumber(fakeDate.phoneNumber().cellPhone());
            employee.setEmail(fakeDate.internet().emailAddress());
            employee.setAddress(fakeDate.address().fullAddress());
            employee.setDesignation(fakeDate.job().position());
    }

    @Test
    public void registrationOfNewEmployee() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://sajithatharaka.github.io/employee_registration/default/basic_details.html");

        driver.findElement(By.id("fname")).sendKeys(employee.getFirstName());
        driver.findElement(By.id("lname")).sendKeys(employee.getLastName());
        driver.findElement(By.id("interest")).sendKeys(employee.getInterest());
        driver.findElement(By.xpath("//a[text()='Next']")).click();

        driver.findElement(By.id("phone")).sendKeys(employee.getPhoneNumber());
        driver.findElement(By.id("email")).sendKeys(employee.getEmail());
        driver.findElement(By.id("address")).sendKeys(employee.getAddress());
        driver.findElement(By.xpath("//a[text()='Next']")).click();


        driver.findElement(By.id("designation")).sendKeys(employee.getDesignation());
        driver.findElement(By.xpath("//a[text()='Next']")).click();

        Thread.sleep(5000);
    }
}
