package com.cybertek.tests.day12_waits_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitTests {

    // We are on break

    String startButtonLocator="#start > button";
    String usernameLocator="#username";
    String passwordLocator="#pwd";
    String buttonLocator="button[type='submit']";
    String loadingBarLocator="#loading";
    String enableButton="#input-example>button";
    String addButtonLocator = "//button[text()='Add']";
    String removeButtonLocator = "//button[text()='Remove']";
    String spinnerLocator = "div[class='fa fa-cog fa-spin']";



    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
       // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }
    @Test
    public void waitForVisibilityTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        driver.findElement(By.cssSelector(startButtonLocator)).click();
        System.out.println(driver.findElement(By.cssSelector(loadingBarLocator)).getText());

        WebDriverWait wait=new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(usernameLocator))));

        driver.findElement(By.cssSelector(usernameLocator)).sendKeys("tomsmith");
        driver.findElement(By.cssSelector(passwordLocator)).sendKeys("SuperSecretPassword");
        driver.findElement(By.cssSelector(buttonLocator)).click();
    }

    @Test
    public void waitElementClickable(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/5");
        WebDriverWait wait = new WebDriverWait(driver , 10);

        //we use this condition to wait until overlay screen will disappear
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(spinnerLocator))));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(buttonLocator)));

        driver.findElement(By.cssSelector(buttonLocator)).click();


    }
    @Test
    public void waitForElementToBeClickable(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        driver.findElement(By.cssSelector(enableButton)).click();
        driver.findElement(By.cssSelector(enableButton)).click();
//        driver.findElement(By.xpath(removeButtonLocator)).click();
        driver.findElement(By.xpath(addButtonLocator)).click();
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
