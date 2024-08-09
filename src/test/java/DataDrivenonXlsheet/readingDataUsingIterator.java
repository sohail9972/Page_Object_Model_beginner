package DataDrivenonXlsheet;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class readingDataUsingIterator {
    public static void main(String[] args) throws IOException {
        String excelFilePath = ".\\src/test/DataFiles/AutoTest.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        Iterator iterator = sheet.iterator();
        while (iterator.hasNext()){
            XSSFRow row = (XSSFRow) iterator.next();

            Iterator cellIteratorRow = row.cellIterator();

            while (cellIteratorRow.hasNext()){
                XSSFCell cell = (XSSFCell) cellIteratorRow.next();
                switch (cell.getCellType()) {
                    case STRING -> {
                        System.out.print(cell.getStringCellValue());
                        break;
                    }
                    case NUMERIC -> {
                        System.out.print(cell.getNumericCellValue());
                        break;
                    }
                    case BOOLEAN -> {
                        System.out.print(cell.getBooleanCellValue());
                        break;
                    }
                }
                System.out.print(" | ");
            }
            System.out.println();

            }
        }
    }

