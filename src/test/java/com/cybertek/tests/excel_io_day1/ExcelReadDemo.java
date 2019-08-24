package com.cybertek.tests.excel_io_day1;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReadDemo {

    Workbook workbook;
    Sheet sheet;
    String path="src/test/resources/Countries.xlsx";
    FileInputStream inputStream;



    @BeforeMethod
    public void setUp() throws IOException {
        inputStream=new FileInputStream(path);
        workbook= WorkbookFactory.create(inputStream);
        sheet=workbook.getSheet("Countries");

//        for (Sheet sheet: workbook) {
//            System.out.println(sheet.getSheetName());
//
//        }
    }

    @Test
    public void readExcelFileRowAndColumnTest(){
        int rowCount=sheet.getLastRowNum();
        System.out.println("Row count: "+ rowCount);

        DataFormatter dataFormatter = new DataFormatter();

        for (Row row: sheet) {

            for(Cell cell: row) {
                System.out.print(dataFormatter.formatCellValue(cell) + "\t");

            }

            System.out.println();
        }

        System.out.println("Number of colums: "+sheet.getRow(0).getLastCellNum());


    }

    @Test
    public void readSingleCellValueTest(){
        Row row =sheet.getRow(0);
        Cell cell=row.getCell(0);
        System.out.println("Value"+cell.getStringCellValue());
        //or
        System.out.println("Value"+sheet.getRow(0).getCell(0));


        String expected="Astana";

        Assert.assertEquals(expected, sheet.getRow(3).getCell(1).toString());


    }
    @Test
    public void readWholeSheet(){
        int rowCount=sheet.getLastRowNum();
        for (int i=0; i<=rowCount; i++){
            String country=sheet.getRow(i).getCell(0).toString(); // or getStringCellValue()
            String capital=sheet.getRow(i).getCell(1).getStringCellValue();

            System.out.println(country +" - "+ capital);
        }


    }

    @Test
    public void putDataIntoMap(){
        Map<String,String> countries=new HashMap<>();
        int rowCount=sheet.getLastRowNum();
        for (int i=0; i<=rowCount; i++){
            String country=sheet.getRow(i).getCell(0).toString(); // or getStringCellValue()
            String capital=sheet.getRow(i).getCell(1).getStringCellValue();
            countries.put(country,capital);

        }

        System.out.println(countries);

        String expected="Moskow";
        String actual=countries.get("Russia");


        Assert.assertEquals(expected,actual);


    }

    @Test
    public void putDataIntoListOfMapsTest(){

        List<Map<String, String>> countries = new ArrayList<>();
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        for (int j = 1; j <= rowCount; j++) {
           Map<String, String> map = new HashMap<>();
            String country = sheet.getRow(j).getCell(0).toString();
            String capital = sheet.getRow(j).getCell(1).toString();

            map.put("country", country);
            map.put("capital", capital);
            countries.add(map);

        }
        System.out.println(countries);

    }


    @AfterMethod
    public void tearDown() throws IOException {
        workbook.close();
        inputStream.close();
    }

}
