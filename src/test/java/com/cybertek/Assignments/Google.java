package com.cybertek.Assignments;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Google {

    static WebDriver driver = BrowserFactory.getDriver("firefox");

    public static void main(String[] args) {
        google();

        driver.close();


    }

    public static void google() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://google.com");

        List<String> searchStrs = Arrays.asList("Java", "JUnit", "REST Assured");

       // List<WebElement> links = driver.findElements(By.tagName("h3"));
        String result="";
        String result2="";
        for (int i=0; i< searchStrs.size(); i++) {

            driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).sendKeys(searchStrs.get(i), Keys.ENTER);


                SeleniumUtils.waitPlease(1);
                result= driver.findElement(By.className("iUh30")).getText();

                System.out.println(result);
                SeleniumUtils.waitPlease(2);

                driver.findElement(By.tagName("h3")).click();

                result2=driver.getCurrentUrl();

                System.out.println(result.equals(result2)? "Passed" : "Failed");


                driver.navigate().back();
                driver.navigate().back();
                SeleniumUtils.waitPlease(1);



        }

    }
}