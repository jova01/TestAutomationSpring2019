package com.cybertek.tests.day5;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LocatorsPracticeTagName {

    static WebDriver driver= BrowserFactory.getDriver("firefox");

    public static void main(String[] args) throws Exception {

        tagName();
    }

    public static void tagName() throws Exception {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

//        List<WebElement> buttons = driver.findElements((By.tagName("button")));
//
//        for (WebElement button: buttons ) {  // first way to do LIST with foreach
//            Thread.sleep(1000);
//            button.click();
//
//        }
//
//        for (int i=0; i<buttons.size(); i++){ // second way to do LIST with forLoop
//            Thread.sleep(1000);
//            buttons.get(i).click();
//        }

        WebElement[] rev= driver.findElements(By.tagName("button")).toArray(new WebElement[0]);

        for (int j=0; j<rev.length; j++){  // forLoop with Array
                Thread.sleep(1000);
                rev[j].click();
            }






        Thread.sleep(1000);
        driver.close();
    }
}
