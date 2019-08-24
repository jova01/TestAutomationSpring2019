package com.cybertek.tests.day16_webtables;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WebTableTests extends TestBase {

    @Test
    public void printTableTest(){
        WebElement table=driver.findElement(By.id("table1"));
        System.out.println(table.getText());
    }

    @Test
    public void printHeaderRow(){
        WebElement header=driver.findElement(By.id("table1")).findElement(By.tagName("thead"));
    }

    @Test // without header, number of rows in the first table
    public void countRowsTest(){

        String locator1="//table[1]//tbody[1]//tr";
        String locator2="table[id='table1'] > tbody > tr"; // second way

        System.out.println("Size : "+driver.findElements(By.xpath(locator1)).size());
        System.out.println("Size : "+driver.findElements(By.cssSelector(locator2)).size());

    }

    @Test // get number of rows in the second table, including heading
    public void countRowsTest2(){
        String locator="#table2 tr";
        System.out.println("Size : "+ driver.findElements(By.cssSelector(locator)).size());
    }

    @Test
    public void task1(){

        String rev="#table1 th"; // one way to find Locator
        String rev2="//table[@id='table1']//th"; //  second way
        String rev3="//table[1]/thead/tr/th";


        List<WebElement> lst=driver.findElements(By.xpath("//table[1]//tr[1]//th"));
        for(WebElement header: lst){
            System.out.println(header.getText());
        }

        for (int i=1; i<=driver.findElements(By.cssSelector(rev)).size(); i++){
            System.out.println(driver.findElement(By.xpath("//table[1]//tr[1]//th["+i+"]")).getText());
        }
    }

    @Test // print certain Row
    public void printCertainRow(){

        String locator1="table:nth-of-type(1) tr:nth-of-type(3)"; // with css locator

        int row=3;
        String locator="//table[1]//tbody//tr["+row+"]";
        WebElement rowElement=driver.findElement(By.xpath(locator));
        System.out.println(rowElement.getText());

    }


    // lets write a method that will return column based on column name
    public List<String> getColumn (String columnName){

        List<WebElement> headings=driver.findElements(By.xpath("//table[1]//th"));
        int columnNumber=0;

        for(int i=1; i<=headings.size(); i++){
            if(headings.get(i-1).getText().equals(columnName)){
                columnNumber=i;
                break;
            }
        }

        List<WebElement> columnList=driver.findElements(By.xpath("//table[1]//tr//td["+columnNumber+"]"));


        List<String> values=new ArrayList<>();
        for(WebElement columnValue: columnList){
            values.add(columnValue.getText());
        }

        return values;
    }

    @Test
    public void printColumnTest(){
        System.out.println(getColumn("Last Name"));
    }

    @Test
    public void verifyThatNameDisplays(){
        String firstName="Jason";
        String lastName="Doe";
        String firstNameLocator="//table[1]//tbody//tr[3]//td[2]";
        String lastNameLocator="//table[1]//tbody//tr[3]//td[1]";

        String actualName=driver.findElement(By.xpath(firstNameLocator)).getText();
        String actualLastName=driver.findElement(By.xpath(lastNameLocator)).getText();

        Assert.assertEquals(firstName,actualName);
        Assert.assertEquals(lastName,actualLastName);
    }

    @Test
    public void verifyThatRecordHasBeenDeletedTest(){
        String firstName = "Jason";
        String lastName = "Doe";
        String firstNameLocator = "//table[1]//tbody//tr[3]//td[2]";
        String lastNameLocator = "//table[1]//tbody//tr[3]//td[1]";

        String target = "//table[1]//td[text()='"+lastName+"']";

        String deleteLocator = "//table[1]//td[text()='"+lastName+"']/following-sibling::td//a[text()='delete']";


        driver.findElement(By.xpath(deleteLocator)).click();

        Assert.assertTrue(driver.findElements(By.xpath(target)).isEmpty());

    }


}
