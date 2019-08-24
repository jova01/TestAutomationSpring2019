package com.cybertek.tests.day8_testing_intro;

import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAndAfterTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://google.com");
    }

    @Test (priority = 1)
    public void test1(){
        Assert.assertTrue(driver.getTitle().contains("Google"));
        SeleniumUtils.waitPlease(1);
    }


    @Test (priority = 2)
    public void test2(){
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        SeleniumUtils.waitPlease(1);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
      //  driver=null;
    }
}
