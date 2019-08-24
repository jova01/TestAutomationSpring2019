package com.cybertek.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;
    public  Actions action;
    public Locators locators;



    @BeforeMethod
    public void setup(){
        driver= Driver.getDriver();

        action= new Actions(driver);
        locators=new Locators(driver);

        driver.manage().timeouts().implicitlyWait(Long.valueOf(ConfigurationReader.getProperty("implicitwait")), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getProperty("url"));



    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
