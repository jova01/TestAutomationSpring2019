package com.cybertek.tests.day6;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Test1 {

    static WebDriver driver = BrowserFactory.getDriver("firefox");

    public static void main(String[] args) throws Exception {
        test1();
    }

    public static void test1() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone X", Keys.ENTER);
        Thread.sleep(2000);

        String actual= driver.getTitle();

        String expected= "Iphone X";

        System.out.println(actual.contains(expected)? "Passed":"Failed");


    }
}
