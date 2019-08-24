package com.cybertek.tests.day15_review;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.VYTrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class QAfirefox {

    public  String createCalendarLocator="a[title^='Create Calendar']";
    public  String repeatCheckBoxLocator="input[id^='recurrence-repeat-view']";
    public  String repeatsDropDownLocator="select[id^='recurrence-repeats-view']";

    String usernameLocator="prependedInput";
    String passwordLocator="prependedInput2";
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("firefox");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/");



    }

    @Test
    public void test1(){
        driver.findElement(By.id(usernameLocator)).sendKeys("storemanager85");
        driver.findElement(By.id(passwordLocator)).sendKeys("UserUser123", Keys.ENTER);
        VYTrackUtils.waitUntilLoaderScreenDissapear(driver);

        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/a/span"))).perform();
        action.moveToElement(driver.findElement(By.xpath("(//*[text()='Calendar Events'])[1]"))).click().perform();

        VYTrackUtils.waitUntilLoaderScreenDissapear(driver);

        driver.findElement(By.cssSelector(createCalendarLocator)).click();
        VYTrackUtils.waitUntilLoaderScreenDissapear(driver);

        driver.findElement(By.cssSelector(repeatCheckBoxLocator)).click();
        List<String> expectedOptions= Arrays.asList("Daily", "Weekly", "Monthly","Yearly");

        Select select = new Select(driver.findElement(By.cssSelector(repeatsDropDownLocator)));

        List<WebElement> options = select.getOptions();

        List<String> optionsTextList = new ArrayList<>();
        for(WebElement option: options){
            optionsTextList.add(option.getText());
        }
        System.out.println(expectedOptions);
        System.out.println(optionsTextList);

        Assert.assertEquals(optionsTextList,expectedOptions);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
