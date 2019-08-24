package com.cybertek.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver =new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        Thread.sleep(1000);
        driver.findElement(By.name("email")).sendKeys("spartan@gmail.com");


        driver.findElement(By.id("form_submit")).click();

        Thread.sleep(1000);

        String actual=driver.findElement(By.name("confirmation_message")).getText();
        String expected="Your e-mail's been sent!";

        System.out.println(actual.equals(expected)? "Test passed" : "Test failed" + "\nActual message: "+ actual
                            +"\nExpected message: "+expected);


        Thread.sleep(2000);

        driver.close();


    }
}
