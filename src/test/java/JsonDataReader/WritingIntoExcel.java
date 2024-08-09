package JsonDataReader;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WritingIntoExcel {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Emplyee Info");

        Object empData[][]={{"EmpId","Name","Job"},
                {"001","nacie","Job1"},
                {"002","Name2","Job2"},
                {"003","Name3","Job3"}}    ;


        int rowCount=0;
        for (Object emp[]:empData){
            XSSFRow row = sheet.createRow(rowCount++);
            int columnCount=0;
            for (Object value : emp){
                XSSFCell cell = row.createCell(columnCount++);
                if (value instanceof String){
                    cell.setCellValue((String) value);
                }
                if (value instanceof Integer){
                    cell.setCellValue((Integer) value);
                }
                if (value instanceof Boolean){
                    cell.setCellValue((Boolean) value);
                }

            }
            String filePath = ".//src/test/DataFiles/sample.xlsx";
            FileOutputStream outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);

            outputStream.close();
            System.out.println("writting completed");
        }
    }

}
