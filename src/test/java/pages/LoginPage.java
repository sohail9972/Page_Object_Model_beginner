package pages;

import automation.testingworld.utility.utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public void enterUserName(String userName) throws IOException {
        driver.findElement(By.id(utility.fetchLocatorsValue("login_userName_id"))).sendKeys(userName);
    }
    public void enterPassword(String password) throws IOException {
        driver.findElement(By.id(utility.fetchLocatorsValue("login_password_id"))).sendKeys(password);
    }
    public void clickingSignIn() throws IOException {
        driver.findElement(By.name(utility.fetchLocatorsValue("login_signin_by_name"))).click();
    }
}
