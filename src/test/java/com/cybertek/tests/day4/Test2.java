package com.cybertek.tests.day4;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {
    public static void main(String[] args) throws  InterruptedException{
        WebDriverManager.chromedriver().setup();

        WebDriver driver =new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");


        Faker faker=new Faker();




            driver.findElement(By.name("email")).sendKeys(faker.internet().emailAddress());

            Thread.sleep(3000);
            driver.findElement(By.name("email")).clear();
            //Thread.sleep(3000);

            driver.findElement(By.name("email")).sendKeys(faker.pokemon().name().toLowerCase() + "@gmail.com", Keys.ENTER);






        Thread.sleep(3000);
        driver.close();
    }
}
