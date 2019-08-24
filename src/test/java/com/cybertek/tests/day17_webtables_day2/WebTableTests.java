package com.cybertek.tests.day17_webtables_day2;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WebTableTests  extends TestBase {



    public int getCountOfRows(){
        return driver.findElements(By.cssSelector("#table1 tr")).size();
    }



    public int getCountOfRows(By by){
        return driver.findElements(by).size();
    }


    @Test
    public void countOfRowTest1(){
        Assert.assertEquals(getCountOfRows(), 5, "Number of rows doesnt match");
    }

    @Test
    public void countOfRowTest2(){
        Assert.assertEquals(getCountOfRows(By.xpath("//table[1]//tr")), 5, "Number of rows doesnt match");
    }

    public int getCountOfColums(By by){
        return driver.findElements(by).size();
    }
    public int getCountOfColums(){
        return driver.findElements(By.cssSelector("#table1 th")).size();
    }

    @Test
    public void countOfColumnTes1(){
        Assert.assertEquals(getCountOfColums(),6, "Number of Rows Doesnt Match");
    }

    public int[] getTableSize(){
        int[] size ={getCountOfRows(), getCountOfColums()};

        return size;
    }

    public int[] getTableSize(By rowLocator, By comlumnLocator){
        int[] size ={getCountOfRows(rowLocator), getCountOfColums(comlumnLocator)};

        return size;
    }

    @Test
    public void tableSizeTest1(){
        int[] expectedSize={5,6};
        int[] actualSize=getTableSize();

        Assert.assertEquals(actualSize,expectedSize, "Doesnt Match");
    }

    @Test
    public void tableSizeTest2(){
        int[] expectedSize={5,6};
        int[] actualSize=getTableSize(By.xpath("//table[1]//tr"),By.cssSelector("#table1 th"));

        Assert.assertEquals(actualSize,expectedSize, "Doesnt Match");
    }


    public List<WebElement> getHeaders(){
        return driver.findElements(By.cssSelector("#table1 th"));
    }

    public List<String> getHeadersText(){
        List<String> headers= new ArrayList<>();
        for(WebElement tableHeader: getHeaders()){
            headers.add(tableHeader.getText());
        }

        return headers;
    }

    @Test
    public void getHeadersTest(){
        List<String> expectedColumnNames = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        Assert.assertEquals(getHeadersText(), expectedColumnNames);
    }

    @Test
    public void sortColumnTest(){
        String columnName="Due";
        driver.findElement(By.xpath("//table[1]//th//span[text()='"+columnName+"']")).click();
        //driver.findElement(By.cssSelector("#table1 th:nth-of-type(4)")).click();

        List<String> list = new ArrayList<>();
        list.addAll(getColumnData(columnName));
        Collections.sort(list);
        Assert.assertEquals(getColumnData(columnName), list);
    }


    public List<String> getColumnData(String columnName){
        int columnNumber=0;
        for(int i=0; i<getCountOfColums(); i++){
            if(columnName.equals(getHeadersText().get(i))){
                columnNumber=i+1;
            }
        }

        String locatorForColumn="//table[1]//tr//td["+columnNumber+"]";
        List<WebElement> columnCollectionOfWebElements=driver.findElements(By.xpath(locatorForColumn));
        List<String> columnCollectionOfText=new ArrayList<>();

        for(WebElement element: columnCollectionOfWebElements){
            columnCollectionOfText.add(element.getText());
        }

        return columnCollectionOfText;
    }
}
