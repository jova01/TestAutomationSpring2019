package com.cybertek.tests.day7;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownPractice {

    static WebDriver driver = BrowserFactory.getDriver("firefox");

    public static void main(String[] args) {

        openCheckBoxesPage();

        test3();
        driver.close();
    }

    public static void openCheckBoxesPage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
        SeleniumUtils.waitPlease(3);
        //driver.findElement(By.xpath("//*[@id=\"state\"]/option[6]")).click();

        WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/h3"));

        SeleniumUtils.verifyIsDisplayed(element);


    }

    public static void test1() {
        WebElement dropdown1 = driver.findElement(By.id("dropdown"));

        SeleniumUtils.waitPlease(2);
        Select dropdownSelect = new Select(dropdown1);
        String actual = dropdownSelect.getFirstSelectedOption().getText();
        String expected = "Please select an option";
        SeleniumUtils.verifyEquals(actual, expected);
        // System.out.println(driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[1]")).getText());

        List<WebElement> options = dropdownSelect.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        // System.out.println(driver.findElement(By.id("dropdown")).getText());
    }

    public static void test2() {
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropDownSelect = new Select(dropdownState);

        List<WebElement> states = dropDownSelect.getOptions();
        for (WebElement element : states) {
            System.out.println(element.getText());
        }
        //let's select virginia
        //we have to use object of Select class
        dropDownSelect.selectByVisibleText("Virginia");
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("Texas");
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("California");
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("Kansas");
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("New Jersey");
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("Florida");
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("Tennessee");
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("Ohio");
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("Colorado");
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("Nebraska");
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("Arkansas");
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("District Of Columbia");
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("Pennsylvania");
    }

    public static void test3() {

//        WebElement dropdownState = driver.findElement(By.id("state"));
//        Select dropDownSelect = new Select(dropdownState);
//        List<WebElement> states = dropDownSelect.getOptions();
//
//        for(WebElement option: states){
//            SeleniumUtils.waitPlease(1);
//            dropDownSelect.selectByVisibleText(option.getText());
//        }


        for (int i = 2; i < 50; i++) {
            SeleniumUtils.waitPlease(1);
            driver.findElement(By.xpath("//*[@id=\"state\"]/option[" + i + "]")).click();
        }
    }

    public static void test4() {
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropDownSelect = new Select(dropdownState);
        //<option value="PA">Pennsylvania</option>
        //means find option that has value PA and select it
        dropDownSelect.selectByValue("PA");
        SeleniumUtils.waitPlease(2);
        String expected = "Pennsylvania";
        String actual = dropDownSelect.getFirstSelectedOption().getText();
        SeleniumUtils.verifyEquals(expected, actual);

    }

    public static void test5() {
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropDownSelect = new Select(dropdownState);
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByIndex(5);
        SeleniumUtils.waitPlease(2);
    }

    public static void test6() {
        WebElement multySelection = driver.findElement(By.xpath("//select[@name='Languages']"));
        Select select = new Select(multySelection);
        SeleniumUtils.waitPlease(2);
        select.selectByVisibleText("Java");
        SeleniumUtils.waitPlease(2);
        select.selectByVisibleText("JavaScript");
        SeleniumUtils.waitPlease(2);

    }
}