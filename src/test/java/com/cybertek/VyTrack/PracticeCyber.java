package com.cybertek.VyTrack;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class PracticeCyber {

    static WebDriver driver = BrowserFactory.getDriver("firefox");

    public static void main(String[] args) throws Exception {

        cyber();
    }

    public static void cyber() throws Exception {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/login");


        String username="tomsmith";
        String password="SuperSecretPassword";

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("12345", Keys.ENTER);


        String expected1= "Your password is invalid!";
        String expected2= "Your username is invalid!";
        String actual= driver.findElement(By.id("flash")).getText();

      //  actual=actual.substring(0,actual.length()-2);


        if (actual.contains(expected1) || actual.contains(expected2)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
            System.out.println("Expected result: "+expected2);
            System.out.println("Actual result: "+ actual);
        }


       Thread.sleep(6000);
       driver.close();






    }
}

