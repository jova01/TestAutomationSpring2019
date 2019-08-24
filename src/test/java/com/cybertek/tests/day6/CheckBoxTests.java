package com.cybertek.tests.day6;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CheckBoxTests {

    static WebDriver driver= BrowserFactory.getDriver("firefox");

    public static void main(String[] args) {

       // test1();

        
        test2();


    }

    public static void openCheckBoxesPage(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkBoxeslogo=driver.findElement(By.tagName("h3"));
        if(checkBoxeslogo.isDisplayed()){
            System.out.println("Checkbox logo Displaying");
        }else {
            System.out.println("Not Displaying");
        }

    }
    public static void test1(){
        openCheckBoxesPage();
        System.out.println(driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).isSelected() ? "Selected" : "Not Selected" );
        System.out.println(driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).isSelected() ? "Selected" : "Not Selected" );
        SeleniumUtils.waitPlease(2);

        driver.close();

    }
    public static void test2(){
        openCheckBoxesPage();

        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).click();

        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).click();

        System.out.println(driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).isSelected()
                && !driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).isSelected() ? "Passed" : "Failed" );


        SeleniumUtils.waitPlease(2);
        driver.close();


    }
}
