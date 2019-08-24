package com.cybertek.VyTrack;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Vyt {


    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception {

        vyt();
    }
    public static void vyt() throws Exception {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        driver.get("http://qa2.vytrack.com");


        driver.findElement(By.id("prependedInput")).sendKeys("user5");
        Thread.sleep(2000);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);

        Thread.sleep(6000);

        driver.findElement(By.className("dropdown-toggle")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Logout")).click();
        Thread.sleep(2000);
        String expected="http://qa2.vytrack.com/user/login";
        String actual=driver.getCurrentUrl();

        if (actual.equals(expected)) {
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
            System.out.println("Expected result: "+expected);
            System.out.println("Actual result: "+actual);
        }

        Thread.sleep(2000);
        driver.close();

    }
}
