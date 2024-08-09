package DataGenerators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class DataGeneratorsAutomation {
    @DataProvider(name="Excel")
//    @DataProvider(name="Static")
    public static Object[][] testDataGenerator() throws IOException {
//        Object [][] data = {{"userName1","Pass"},{"userName2","Pass2"},{"UserName3","Pass"}};
//        return data;


        FileInputStream file = new FileInputStream("src/test/DataFiles/AutoTest.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet loginSheet = workbook.getSheet("Sheet1");
        int numberofRows = loginSheet.getPhysicalNumberOfRows();
        Object [][] testdata = new Object[numberofRows][2];

        for (int i=0;i<numberofRows;i++){
            XSSFRow row = loginSheet.getRow(i);
            XSSFCell usname= row.getCell(0);
            XSSFCell password = row.getCell(1);
            testdata[i][0]= usname.getStringCellValue();
            testdata[i][1]= password.getStringCellValue();

        }
        return testdata;
    }
}
