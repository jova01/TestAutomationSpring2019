package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VYTrackUtils {

    private static String usernameLocator="prependedInput";
    private static String passwordLocator="prependedInput2";
    private static String loaderMaskLocator="div[class='loader-mask shown']";



    public static void login(WebDriver driver, String username, String password){

        driver.findElement(By.id(usernameLocator)).sendKeys(username);
        driver.findElement(By.id(passwordLocator)).sendKeys(password, Keys.ENTER);
        SeleniumUtils.waitPlease(2);
    }

    public static void navigateToModule(WebDriver driver, String tab, String module){
        String tabLocator = "//span[contains(text(),'"+tab+"') and contains(@class, 'title title-level-1')]";
        String moduleLocator = "//span[contains(text(),'"+module+"') and contains(@class, 'title title-level-2')]";
        waitUntilLoaderScreenDissapear(driver);

        // SeleniumUtils.clickWithWait(driver, By.xpath(tabLocator), 5);
        driver.findElement(By.xpath(tabLocator)).click();
        driver.findElement(By.xpath(moduleLocator)).click();

    }

    public static void waitUntilLoaderScreenDissapear(WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver, Long.valueOf(ConfigurationReader.getProperty("explicitwait")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(loaderMaskLocator))));



    }



}
