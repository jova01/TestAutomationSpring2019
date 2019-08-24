package com.cybertek.tests.day8_testing_intro;

import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practice {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void test1() {
        int year = 2019;
        String month = "July";
        int day = 7;
        SeleniumUtils.waitPlease(1);

        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        int getYear = Integer.parseInt(selectYear.getFirstSelectedOption().getText());
        String getMonth = selectMonth.getFirstSelectedOption().getText();
        int getDay = Integer.parseInt(selectDay.getFirstSelectedOption().getText());


        Assert.assertEquals(getYear, year);
        Assert.assertEquals(getMonth, month);
        Assert.assertEquals(getDay, day);
    }


    @AfterMethod
    public void after(){
        driver.quit();
    }
}
