package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    /**
     * @param browser name
     * @return browser object, otherwise throw exception to prevent test run
     */

    public static WebDriver getDriver(String browser){

        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else if (browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();

        }else if (browser.equals("safari")){

            return new SafariDriver();
        }else {
            throw new IllegalArgumentException("Wrong Browser Name");
        }

    }
}
