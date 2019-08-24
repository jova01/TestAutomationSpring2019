package com.cybertek.pages.vytrack;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class CalendarEventsPage {

    // a[class^='btn main']    ///    ^ means starts With
    /// # works for id

   private  WebDriver driver= Driver.getDriver();


//   String createCalendarLocator="a[class^='btn main']";
  public  String createCalendarLocator="a[title^='Create Calendar']";
  public  String repeatCheckBoxLocator="input[id^='recurrence-repeat-view']";
  //public  String repeatsDropDownLocator="select[id^='recurrence-repeats-view']";
    public  String repeatsDropDownLocator="recurrence-repeats__select";


    //    let's write a method that would return collection of repeat options
    public List<String> getRepeatOptions(){
        //we crated select object to work with dropdown
        Select select = new Select(driver.findElement(By.className(repeatsDropDownLocator)));
        //.getOptions(); return all available options in the dropdown.
        //every option is a webelement
        List<WebElement> options = select.getOptions();
        //this is a collection that will store text of every option
        List<String> optionsTextList = new ArrayList<>();
        for(WebElement option: options){
            //go through every option and retrieve text
            //add that text into collection of text options
            optionsTextList.add(option.getText());
        }
        return  optionsTextList;




    }


}
