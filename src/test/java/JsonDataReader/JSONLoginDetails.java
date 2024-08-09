package JsonDataReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;

public class JSONLoginDetails {

    WebDriver driver;

    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
    }

    @AfterClass
    void tearDown(){
        driver.close();
    }

    @Test(dataProvider = "jsonfile")
    void login(String data){

        String userName[]=data.split(",");
        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys(userName[0]);
        driver.findElement(By.id("pass")).sendKeys(userName[1]);
        driver.findElement(By.name("login")).click();

//        String act_title= driver.getTitle();
//        String expected_title = "nopCommerce demo store";
//        Assert.assertEquals(act_title,expected_title);
    }

    @DataProvider(name="jsonfile")
    public String[] readjson() throws FileNotFoundException {
        FileReader reader = new FileReader("src/test/DataFiles/JsonDataStructure.json");
        JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
        JsonArray userLogin = jsonObject.getAsJsonArray("userlogins");

        String [] arr = new String[userLogin.size()];
        for (int i=0;i<userLogin.size();i++){
            JsonObject users = (JsonObject) userLogin.get(i);
            String user = String.valueOf(users.get("username"));
            String pwd = String.valueOf(users.get("password"));

            arr[i]=user+","+pwd;
        }
        return arr;
    }

}
