package com.cybertek.Assignments;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class VytrackFunction {
    static WebDriver driver = BrowserFactory.getDriver("firefox");

    public static void main(String[] args) {

        vyt();

        driver.close();
    }

    public static void vyt() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        driver.get("http://qa2.vytrack.com");


        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager104");
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);

        SeleniumUtils.waitPlease(6);
        String title=driver.getTitle();
        System.out.println(title.contains("Dashboard")? "Dashboard page is open": "Not open");


        driver.findElement(By.xpath("//*[@id=\"oroplatform-header\"]/div[1]/div/div[2]/div/a/i")).click();

        SeleniumUtils.waitPlease(5);

        driver.findElement(By.xpath("//*[@id=\"oroplatform-header\"]/div[1]/div/div[2]/div/ul/li[2]/form/div/div/a")).click();

        SeleniumUtils.waitPlease(2);

        driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/table/tbody/tr[21]/td[1]/a")).click();

        SeleniumUtils.waitPlease(4);
        String open="Open Opportunities";
        System.out.println(driver.getTitle().contains(open)? "Open Oppotunities page is open": "Not Open");


        driver.findElement(By.xpath("//*[@id=\"oroplatform-header\"]/div[1]/div/div[2]/div/a/i")).click();
        SeleniumUtils.waitPlease(4);
        driver.findElement(By.xpath("//*[@id=\"oroplatform-header\"]/div[1]/div/div[2]/div/ul/li[2]/form/div/div/a")).click();
        SeleniumUtils.waitPlease(4);

        driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/table/tbody/tr[17]/td[1]/a")).click();
        SeleniumUtils.waitPlease(4);

        String message="You do not have permission to perform this action.";

        System.out.println(driver.findElement(By.className("message")).getText().equals(message)?
                "Message text is Equal" : "Not Equal Messages");

        SeleniumUtils.waitPlease(2);

        System.out.println(driver.getTitle().contains("Open Opportunities")? "Open Oppotunities page is open": "Open Oppotunities page is not  open");

        SeleniumUtils.waitPlease(4);



    }
}
