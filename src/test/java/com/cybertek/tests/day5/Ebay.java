package com.cybertek.tests.day5;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Ebay {
    static WebDriver driver = BrowserFactory.getDriver("firefox");

    public static void main(String[] args) throws Exception {

        tagName();
    }

    public static void tagName() throws Exception {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.ebay.com/");

        driver.findElement(By.id("gh-ac")).sendKeys("java", Keys.ENTER);

        Thread.sleep(2000);

        String rev= driver.findElement(By.className("srp-controls__count-heading")).getText();

        System.out.println(rev);
        driver.close();

    }
}