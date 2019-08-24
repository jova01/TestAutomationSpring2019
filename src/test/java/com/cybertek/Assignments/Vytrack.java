package com.cybertek.Assignments;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Vytrack {
    static WebDriver driver = BrowserFactory.getDriver("firefox");

    public static void main(String[] args)  {

        vyt();

        driver.close();
    }

    public static void vyt()  {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        driver.get("http://qa2.vytrack.com");


        driver.findElement(By.id("prependedInput")).sendKeys("user5");
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);

        SeleniumUtils.waitPlease(6);
        String name1=driver.findElement(By.className("dropdown-toggle")).getText();
        System.out.println(name1);

        SeleniumUtils.waitPlease(1);

        driver.findElement(By.className("dropdown-toggle")).click();

        SeleniumUtils.waitPlease(1);

        driver.findElement(By.xpath("//*[@id=\"user-menu\"]/ul/li[2]/a")).click();

        SeleniumUtils.waitPlease(3);
        String name2=driver.getTitle();

        System.out.println(name2.contains(name1)? "Passed Equal" : "Not Equal");





    }
}