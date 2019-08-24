package com.cybertek.tests.day6;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Test2 {


    static WebDriver driver = BrowserFactory.getDriver("firefox");

    public static void main(String[] args) throws Exception {
        test2();
    }

    public static void test2() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://wikipedia.org");

        Thread.sleep(1000);

        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.linkText("Selenium (software)")).click();
        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl().endsWith("x") ? "Pass" :"Fail");

        driver.close();


    }
}