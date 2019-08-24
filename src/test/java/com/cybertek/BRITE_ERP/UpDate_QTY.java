package com.cybertek.BRITE_ERP;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UpDate_QTY {

    WebDriver driver;

    String username="manuf_user10@info.com";
    String password="manufuser";

    String manufacturingBarLocator="[data-menu-xmlid='mrp.menu_mrp_root']";
    String productsLocator="[data-menu-xmlid='mrp.menu_mrp_product_form']";
    String firstProductBookLocator="/html/body/div[1]/div[2]/div[2]/div/div/div/div[5]/div[1]";
    String updateQTYLocator="button[class='btn btn-sm btn-default']";
    String amountLocator="input[name='new_quantity']";
    String applyButtonLocator="button[name='change_product_qty']";
    String notificationLocator="div[class='o_notification_title']";
    String checkBoxLocator="/html/body/div[1]/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[1]/div/input";
    String actionLocator="/html/body/div[1]/div[2]/div[1]/div[2]/div[2]/div/div[2]/button";
    String exportLocator="/html/body/div[1]/div[2]/div[1]/div[2]/div[2]/div/div[2]/ul/li[1]/a";
    String excelFormatLocator="input[value='xls']";
    String addButtonLocator="button[class='btn btn-sm btn-default o_add_field']";
    String priorityLocator="div[data-id='priority']";
    String procurementDocumentLocator="div[data-id='procurement_group_id']";
    String productDocumentLocator="div[data-id='product_id']";
    String loading="div.blockUI.blockOverlay";
    String exportToFileLocator="button[class='btn btn-sm btn-primary']";

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://54.148.96.210/web/login");
        driver.findElement(By.id("login")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password, Keys.ENTER);

    }

    @Test (description = "As manager I should be able to update QTY")
    public void test1(){
        driver.findElement(By.cssSelector(manufacturingBarLocator)).click();
        driver.findElement(By.cssSelector(productsLocator)).click();
        driver.findElement(By.xpath(firstProductBookLocator)).click();
        driver.findElement(By.cssSelector(updateQTYLocator)).click();

        SeleniumUtils.waitPlease(2);
        driver.findElement(By.cssSelector(amountLocator)).clear();
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.cssSelector(amountLocator)).sendKeys("100");
        driver.findElement(By.cssSelector(applyButtonLocator)).click();
        SeleniumUtils.waitPlease(2);

        String expectedResult="Saved";
        String actualResult=driver.findElement(By.cssSelector(notificationLocator)).getText();

        Assert.assertNotEquals(expectedResult,actualResult);

    }

    @Test (description = "As manager I should be able to Export any data as Excel file")
    public void test2(){
        driver.findElement(By.cssSelector(manufacturingBarLocator)).click();
        driver.findElement(By.xpath(checkBoxLocator)).click();
        driver.findElement(By.xpath(actionLocator)).click();
        driver.findElement(By.xpath(exportLocator)).click();
        SeleniumUtils.waitPlease(2);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.cssSelector(priorityLocator)));

        SeleniumUtils.waitPlease(1);
        driver.findElement(By.cssSelector(priorityLocator)).click();
        SeleniumUtils.waitPlease(1);

        driver.findElement(By.cssSelector(addButtonLocator)).click();
        SeleniumUtils.waitPlease(1);

        driver.findElement(By.cssSelector(procurementDocumentLocator)).click();
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.cssSelector(addButtonLocator)).click();
        SeleniumUtils.waitPlease(1);

        driver.findElement(By.cssSelector(productDocumentLocator)).click();
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.cssSelector(addButtonLocator)).click();

        SeleniumUtils.waitPlease(1);
        driver.findElement(By.cssSelector(excelFormatLocator)).click();

        SeleniumUtils.waitPlease(2);
        driver.findElement(By.cssSelector(exportToFileLocator)).click();


        System.out.println(driver.findElement(By.cssSelector(loading)).isDisplayed());



    }

    @AfterMethod
    public void tearDown(){
        SeleniumUtils.waitPlease(2);
        driver.quit();
    }

}

