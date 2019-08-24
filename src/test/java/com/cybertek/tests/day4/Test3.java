package com.cybertek.tests.day4;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver =new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");


        Faker faker=new Faker();




        driver.findElement(By.name("email")).sendKeys(faker.internet().emailAddress());


        System.out.println(driver.findElement(By.name("email")).getAttribute("pattern")); // what inbox is required to enter
        System.out.println(driver.findElement(By.name("email")).getAttribute("value")); //text u input into box
        driver.findElement(By.id("form_submit")).submit();



        Thread.sleep(1000);
        driver.close();
    }
}
