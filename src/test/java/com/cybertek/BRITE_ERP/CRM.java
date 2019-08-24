package com.cybertek.BRITE_ERP;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CRM {

    WebDriver driver;
    String username = "eventscrmmanager10@info.com";
    String password = "eventscrmmanager";

    String CRMLocator="a[data-menu='261']";
    String createButtonLocator="button[class='btn btn-primary btn-sm o-kanban-button-new']";
    String titleLocator="[placeholder^='e.g. Customer Deal']";
    String customerDropDownLocator="input[class='o_input ui-autocomplete-input']";
    String companyNameLocator="li[class='ui-menu-item']:nth-of-type(2)";
    String revenueLocator="[class='o_field_float o_field_number o_field_widget o_input']";
    String starLocator="//tr//td//div//a[3]";
    String createLocator="button[class='btn btn-sm btn-primary']:nth-of-type(1)";


    String listLocator="button[accesskey='l']";
    String googleCheckBoxLocator="/html/body/div[1]/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[1]/div/input";
    String appleCheckBoxLocator="/html/body/div[1]/div[2]/div[2]/div/div/div/table/tbody/tr[2]/td[1]/div/input";
    String actionLocator="/html/body/div[1]/div[2]/div[1]/div[2]/div[2]/div/div[2]/button";
    String DeleteLocator="a[data-index='3']";
    String OkButtonLocator="button[class='btn btn-sm btn-primary']";

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://54.148.96.210/web/login");
        driver.findElement(By.id("login")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password, Keys.ENTER);
    }

    @Test
    public void crmTest(){
        driver.findElement(By.cssSelector(CRMLocator)).click();

        String company ="Apple";
        String revenue="12000";
        for (int i=0; i<2; i++) {
            driver.findElement(By.cssSelector(createButtonLocator)).click();
            driver.findElement(By.cssSelector(titleLocator)).sendKeys(company);
            driver.findElement(By.cssSelector(customerDropDownLocator)).click();
            driver.findElement(By.cssSelector(companyNameLocator)).click();
            driver.findElement(By.cssSelector(revenueLocator)).clear();
            driver.findElement(By.cssSelector(revenueLocator)).sendKeys(revenue);
            driver.findElement(By.xpath(starLocator)).click();
            driver.findElement(By.cssSelector(createLocator)).click();
            SeleniumUtils.waitPlease(1);
            company="Google";
            revenue="30000";
        }


        driver.findElement(By.cssSelector(listLocator)).click();
        driver.findElement(By.xpath(googleCheckBoxLocator)).click();
        driver.findElement(By.xpath(appleCheckBoxLocator)).click();
        driver.findElement(By.xpath(actionLocator)).click();
        driver.findElement(By.cssSelector(DeleteLocator)).click();
        driver.findElement(By.cssSelector(OkButtonLocator)).click();




    }


    @AfterMethod
    public void tearDown(){
        SeleniumUtils.waitPlease(2);
        driver.quit();
    }
}
