package com.cybertek.tests.day5;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LocatorsPracticeXpath {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/sign_up");
        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("James Bond");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("student@gmail.com");
        driver.findElement(By.xpath("//button[@name='wooden_spoon']")).click();
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        driver.close();

    }

}
