package com.cybertek.tests.day6;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LinkTextExample {
    static WebDriver driver = BrowserFactory.getDriver("firefox");

    public static void main(String[] args) throws Exception {
        test2();
    }

    public static void test1() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com");
        driver.findElement(By.linkText("A/B Testing")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        driver.findElement(By.linkText("Dropdown")).click();
        Thread.sleep(2000);
        driver.close();
    }

    public static void test2() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com");
        Thread.sleep(2000);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (int i = 1; i < links.size(); i++) {
            //if it's 5th link, skip it
            if (i == 4) {
                continue;
            }
//            Thread.sleep(1000);
            links.get(i).click();
//            Thread.sleep(1000);
            driver.navigate().back();
//            Thread.sleep(1000);
            //we have o find all elements again, otherwise we will get StaleElementReferenceException
            links = driver.findElements(By.tagName("a"));
            System.out.println(links.get(i).getText());

        }
        driver.close();
    }

}