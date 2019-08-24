package com.cybertek.tests.day9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class July_09 {

    public static void main(String[] args) {
        /*
        Topic: Select class

            Select class is used for handling drop down boxes with tagname of Select

            declaration of select class:
                        Select variableName= new Select(WebElement of Drop down box);

            Methods of Select class:
                        selectByindex(int):   selects the options in drop down box by the index number
                        selectByValue(String):  selects the options in drop down box by the value
                        selectByvisibletext(String): selects the options in drop down box by visibletext
                        getoptions(): returns list of WebElements, returns all the options



         */

        test2();



    }


    public static void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

        sleep(3);

            /*
            <select aria-label="Month" name="birthday_month" id="month" title="Month" class="_5dba">
                    //select[@aria-label='Month']
             */
        WebElement monthDB = driver.findElement(By.xpath("//select[@aria-label='Month']"));

        Select month = new Select(monthDB);
        // select by index:
        month.selectByIndex(5);

        sleep(3);
        // select by value:
        month.selectByValue("11");

        sleep(3);
        // selecy by visible text:
        month.selectByVisibleText("Sep");

        List<WebElement> list1 = month.getOptions();
        WebElement september= list1.get(9);
        System.out.println( september.isSelected() );




    }


    public static void test2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

        sleep(3);

            /*
            <select aria-label="Year" name="birthday_year" id="year" title="Year" class="_5dba">

             */
        WebElement yearDB =driver.findElement(By.name("birthday_year"));
        Select year = new Select(yearDB);
        year.selectByVisibleText("1909");
        sleep(3);
        List<WebElement> list =  year.getOptions();
        WebElement Y1909 =null;

        for(WebElement each :list) {
            if (each.getText().equals("1909")) {

                Y1909 = each;
                break;
            }
        }


        System.out.println( Y1909.isSelected() );





    }



    public static void sleep(double a){

        try {
            Thread.sleep((long)a*1000);

        } catch (InterruptedException e) {

        }

    }






}
