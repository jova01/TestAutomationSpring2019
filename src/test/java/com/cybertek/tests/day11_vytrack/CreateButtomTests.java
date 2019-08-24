package com.cybertek.tests.day11_vytrack;

import com.cybertek.utilities.SeleniumUtils;
import com.cybertek.utilities.VYTrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreateButtomTests {

    WebDriver driver;
    String createButtonLocator="a[title='Log call']";
    String createCalendarEventButton="a[title='Create Calendar event']";
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://qa2.vytrack.com/user/login");

    }

    @Test(priority = 1)
    public void storeManagerTest(){
        VYTrackUtils.login(driver,"storemanager85", "UserUser123");
        SeleniumUtils.waitPlease(6);
        VYTrackUtils.navigateToModule(driver, "Activities","Calls");
        Assert.assertTrue(driver.findElement(By.cssSelector(createButtonLocator)).isDisplayed());
        SeleniumUtils.waitPlease(2);
        VYTrackUtils.navigateToModule(driver, "Activities","Calendar Events");
        Assert.assertTrue(driver.findElement(By.cssSelector(createCalendarEventButton)).isDisplayed());

    }
    @Test (priority = 2)
    public void salesManagerTest(){

        VYTrackUtils.login(driver, "salesmanager104", "UserUser123");
        SeleniumUtils.waitPlease(5);
        VYTrackUtils.navigateToModule(driver, "Activities", "Calls");
        Assert.assertTrue(driver.findElement(By.cssSelector(createButtonLocator)).isDisplayed());

        SeleniumUtils.waitPlease(2);
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        Assert.assertTrue(driver.findElement(By.cssSelector(createCalendarEventButton)).isDisplayed());

    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }


}
