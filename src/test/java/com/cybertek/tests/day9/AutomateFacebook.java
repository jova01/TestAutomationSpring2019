package com.cybertek.tests.day9;

import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomateFacebook {

    public static void main(String[] args) {
        //Test1();
        //Test2();
        Test3();
    }

    public static void Test1(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");

        boolean title = driver.getTitle().contains("Facebook");
        //System.out.println(driver.getCurrentUrl());
        boolean URL = driver.getCurrentUrl().equals("https://www.facebook.com");

        System.out.println(title);
        System.out.println(URL);

        driver.quit();
    }

    public static void Test2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");

        List<WebElement> allRadioButton = driver.findElements(By.xpath("//input[@type='radio']"));
        WebElement FemaleRadioButton = allRadioButton.get(0);
        WebElement MaleRadioButton = allRadioButton.get(1);
        WebElement Custom = allRadioButton.get(2);

        FemaleRadioButton.click();
        boolean A = FemaleRadioButton.isSelected();
        SeleniumUtils.waitPlease(3);

        MaleRadioButton.click();
        boolean B = MaleRadioButton.isSelected();
        SeleniumUtils.waitPlease(3);

        Custom.click();
        Boolean C = Custom.isSelected();
        SeleniumUtils.waitPlease(3);

        System.out.println(A);
        System.out.println(B);
        System.out.println(C);


        WebElement customText = driver.findElements(By.xpath("//*[contains(text(),'Custom')]")).get(0);
        WebElement femaleText = driver.findElement(By.xpath("//*[contains(text(),'Female')]"));
        WebElement maleText = driver.findElement(By.xpath("//*[contains(text(),'Male')]"));

        femaleText.click();
        boolean D = femaleText.isSelected();
        SeleniumUtils.waitPlease(3);

        maleText.click();
        boolean E = maleText.isSelected();
        SeleniumUtils.waitPlease(3);

        customText.click();
        boolean F = customText.isSelected();
        SeleniumUtils.waitPlease(3);


        driver.quit();
    }

    public static void Test3(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");

        WebElement signUp = driver.findElement(By.name("websubmit"));

        signUp.click();
        boolean G = signUp.isEnabled();
        SeleniumUtils.waitPlease(3);

        System.out.println("Supper "+G);

        driver.close();
    }


}
