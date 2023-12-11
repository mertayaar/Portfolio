package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class ExcelUtilities {
    public static List<List<String>> getFromExcel(String path, String sheetName, int columnCount) {
        List<List<String>> returnList = new ArrayList<>();
        FileInputStream fileInputStream;
        Workbook workbook;
        Sheet sheet = null;

        try {
            fileInputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(fileInputStream);
            sheet = workbook.getSheet(sheetName);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            List<String> innerList = new ArrayList<>();
            for (int j = 0; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
                innerList.add(sheet.getRow(i).getCell(j).toString());

            }
            returnList.add(innerList);

        }
        return returnList;

    }

    public static void writeInExcel(String path, Scenario scenario, LocalDateTime startTime, LocalDateTime endTime, Duration duration) {
        File file = new File(path);

        if (file.exists()) {
            Sheet sheet;
            Workbook workbook;
            try {
                FileInputStream fileInputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(fileInputStream);
                sheet = workbook.getSheet("TestResults");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            int rowCount = sheet.getPhysicalNumberOfRows();
            Row row1 = sheet.createRow(rowCount);
            Row row = sheet.createRow(rowCount + 1);
            row.createCell(0).setCellValue(System.getProperty("user.name"));
            row.createCell(1).setCellValue(System.getProperty("os.name"));
            row1.createCell(0).setCellValue(scenario.getId());
            row1.createCell(1).setCellValue(scenario.getName());
            row1.createCell(2).setCellValue(scenario.getStatus().toString());
            row1.createCell(3).setCellValue(startTime.toString());
            row1.createCell(4).setCellValue(endTime.toString());
            row1.createCell(5).setCellValue(duration.toString());

            try {
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                workbook.write(fileOutputStream);
                workbook.close();
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        } else {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("CampusTestResults");
            Row row1 = sheet.createRow(1);
            Row row = sheet.createRow(0);
            row.createCell(0).setCellValue(System.getProperty("user.name"));
            row.createCell(1).setCellValue(System.getProperty("os.name"));

            row1.createCell(0).setCellValue(scenario.getId());
            row1.createCell(1).setCellValue(scenario.getName());
            row1.createCell(2).setCellValue(scenario.getStatus().toString());
            row1.createCell(3).setCellValue(startTime.toString());
            row1.createCell(4).setCellValue(endTime.toString());
            row1.createCell(5).setCellValue(duration.toString());

            try {
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                workbook.write(fileOutputStream);
                workbook.close();
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }


    }

}
