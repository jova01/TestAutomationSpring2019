package com.cybertek.tests.day6;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioButtonsTests {

    static WebDriver driver = BrowserFactory.getDriver("firefox");
    public static void main(String[] args) {
    openRadioButtonPage();
    test5();
    driver.close();


    }
    public static void openRadioButtonPage(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/radio_buttons");

    }

    public  static void test1() {
       WebElement blueBtn= driver.findElement(By.id("blue"));

       if(blueBtn.isSelected()){
           System.out.println("Passed");
       }else{
           System.out.println("Failed");
       }

       SeleniumUtils.waitPlease(2);


    }
    public static void test2(){
        System.out.println( driver.findElement(By.id("black")).isEnabled() && !driver.findElement(By.id("green")).isEnabled()
                    ? "Passed": "Failed");


        SeleniumUtils.waitPlease(2);
    }

    public static void test4(){
        System.out.println(driver.findElement(By.id("blue")).isSelected() ? "Blue is Selected" : "Blue is Not Selected");

        SeleniumUtils.waitPlease(2);
        driver.findElement(By.id("black")).click();

        System.out.println(driver.findElement(By.id("black")).isSelected()? "Black is Selected" : "Black is Not Selected");


        System.out.println(driver.findElement(By.id("blue")).isSelected() ? "Blue is Selected" : "Blue is Not Selected");

        SeleniumUtils.waitPlease(2);
    }
    public static void test5(){
        List<WebElement> listofRadioButtons =driver.findElements(By.xpath("//input[@type='radio']"));
        int counter=0;

        for (WebElement radioButton: listofRadioButtons){
            if (radioButton.isSelected()){
                System.out.println(radioButton.getAttribute("id"));
                counter++;
            }

        }
        System.out.println(counter);

        SeleniumUtils.waitPlease(2);


    }


}
