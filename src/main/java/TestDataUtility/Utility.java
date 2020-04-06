package main.java.TestDataUtility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

public class Utility {

    public static String getPropertyAndLoadFile(String key) {
        Properties prop = new Properties();

        String filename = "Config.properties";
        String workingDirectory = System.getProperty("user.dir");
        String absoluteFilePath = "";
        absoluteFilePath = workingDirectory + File.separator + "src" + File.separator + "main" + File.separator +
                "resources" + File.separator + "Config" + File.separator + filename;

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(absoluteFilePath);
        } catch (Exception e) {
            e.getMessage();
        }

        try {
            assert fis != null;
            prop.load(fis);
        } catch (IOException e) {
            e.getMessage();
        }


        return prop.getProperty(key);
    }

    public static String getExcelData(String excelFilePath) {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(excelFilePath));
        } catch (FileNotFoundException e) {
            e.getMessage();
        }

        Workbook workbook = null;
        try {
            assert inputStream != null;
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.getMessage();
        }
        assert workbook != null;
        Sheet firstSheet = workbook.getSheetAt(0);

        for (Row nextRow : firstSheet) {
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                }
                System.out.print(" - ");
            }
            System.out.println();
        }

        try {
            workbook.close();
        } catch (IOException e) {
            e.getMessage();
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            e.getMessage();
        }
        return excelFilePath;
    }
}