package com.cybertek.tests.day12_waits_practice;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ThreadSleepAndImplicitWait {

    String helloWorld="#finish";
    String startButtonLocator="#start > button";

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");

    }

    @Test
    public void waitTest1(){

        driver.findElement(By.cssSelector(startButtonLocator)).click();
        String expectedResult="Hello World!";
        String actualResult=driver.findElement(By.cssSelector(helloWorld)).getText();
        Assert.assertEquals(actualResult,expectedResult);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
