package com.cybertek.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Locators {

    public Locators(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "prependedInput")
    public WebElement usernameIdLocator;


    @FindBy(id = "prependedInput2")
    public WebElement passwordIdLocator;


    @FindBy(id="_submit")
    public WebElement loginButtonIdLocator;

    @FindBy(linkText = "Fleet")
    public WebElement fleetLocator;

}
