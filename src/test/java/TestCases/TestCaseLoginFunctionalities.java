package TestCases;

import Basefile.DriverInstance;
import DataGenerators.DataGeneratorsAutomation;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestCaseLoginFunctionalities extends DriverInstance {
//    @Test(dataProvider = "Static")
    @Test(dataProvider = "Excel",dataProviderClass = DataGeneratorsAutomation.class)
    public void testCaaseFirst(String usname, String pass) throws IOException {
        LoginPage login = new LoginPage(driver);
        login.enterUserName(usname);
        login.enterPassword(pass);
        login.clickingSignIn();
    }
}
