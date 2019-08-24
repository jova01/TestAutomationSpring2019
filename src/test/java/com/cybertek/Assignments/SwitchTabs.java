package com.cybertek.Assignments;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class SwitchTabs {

    WebDriver driver ;
    @Test
    public void test(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("https://www.google.com/gmail/about/");


        driver.findElement(By.cssSelector("[title = 'Create an account']")).click();

        Set<String> str =  driver.getWindowHandles();



        Iterator<String> lst = str.iterator();
        String parent = lst.next();
        String child  = lst.next();


        driver.switchTo().window(child);
        System.out.println(driver.getTitle());

        SeleniumUtils.waitPlease(1);

        driver.switchTo().window(parent);
        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void tearDown(){
        SeleniumUtils.waitPlease(2);
        driver.quit();
    }
}
