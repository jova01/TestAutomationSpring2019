package com.cybertek.Assignments;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Ebay {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        ebay();

        driver.close();


    }

    public static void ebay() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.ebay.com/");
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.id("gh-ac")).sendKeys("wooden spoon", Keys.ENTER);

        String result=driver.findElement(By.className("srp-controls__count-heading")).getText();

        SeleniumUtils.waitPlease(1);

        driver.findElement(By.xpath("//*[@id=\"w3\"]/li[1]/ul/li[1]/ul/li/a/span")).click();

        String result2=driver.findElement(By.className("srp-controls__count-heading")).getText();


        String rev="";
        for (int i = 0; i < result.length(); i++) {
            if(Character.isDigit(result.charAt(i))) {
                rev+=result.charAt(i);
            }
        }
        String str="";
        for (int i = 0; i < result2.length(); i++) {
            if(Character.isDigit(result2.charAt(i))) {
                str+=result2.charAt(i);
            }
        }

        Integer res1=Integer.parseInt(rev);
        Integer res2=Integer.parseInt(str);

        System.out.println(res2>res1 ? "Result 2 is bigger": "Is not bigger");

        SeleniumUtils.waitPlease(1);

        driver.navigate().back();

        String title=driver.getTitle();

        System.out.println(title.contains("wooden spoon") ?
                "wooden spoon is Displayed": "Not Displayed");

        driver.navigate().back();



        String checkbox= driver.findElement(By.id("gh-ac")).getAttribute("value");


        System.out.println(checkbox.length()==0 ? "Search box is Empty": "Not Empty");

        SeleniumUtils.waitPlease(1);



    }
}