package com.cybertek.tests.day13_actions_jsexecutor;

import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorTests {
    WebDriver driver;



    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }


    @Test
    public void jsExecutorTest1(){
        driver.get("http://practice.cybertekschool.com/");
        JavascriptExecutor js= (JavascriptExecutor) driver;

        String title= (String) js.executeScript("return document.title");

        js.executeScript("alert('HELLO SPARTANS!!!!')");
        SeleniumUtils.waitPlease(3);
        Alert alert=driver.switchTo().alert();
       // alert.accept();
        //alert.dismiss();
        SeleniumUtils.waitPlease(3);
        System.out.println(title);
    }

    @Test
    public void scrollTest1(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");

        JavascriptExecutor js= (JavascriptExecutor) driver;

        for (int i=0; i<11; i++){
            js.executeScript("window.scrollBy(0,250)");
            SeleniumUtils.waitPlease(1);
        }
    }

    @Test
    public void scrollTest2(){
        driver.get("http://practice.cybertekschool.com/");
        WebElement footerLink=driver.findElement(By.linkText("Cybertek School"));

        JavascriptExecutor js= (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true)",footerLink);
        SeleniumUtils.waitPlease(2);
        js.executeScript("arguments[0].click()",footerLink);
        SeleniumUtils.waitPlease(2);

    }

    @Test
    public void jsSendKeys()  {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element = driver.findElement(By.cssSelector("#input-example>input"));
        SeleniumUtils.waitPlease(2);
        String text = "asdfasfsadfasdf";
        js.executeScript("arguments[0].setAttribute('value', '" + text +"')", element);
        SeleniumUtils.waitPlease(3);
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
