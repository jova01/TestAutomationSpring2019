package com.cybertek.tests.day15_review;

import com.cybertek.pages.vytrack.CalendarEventsPage;
import com.cybertek.utilities.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.VYTrackUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Calendar_EventsTests  extends TestBase {

    //Before Method is coming from TestBase

    CalendarEventsPage calendarPage=new CalendarEventsPage();

    @Test
    public void verifyRepeatOptions(){
        VYTrackUtils.login(driver, ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));



        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        VYTrackUtils.waitUntilLoaderScreenDissapear(driver);


        driver.findElement(By.cssSelector(calendarPage.createCalendarLocator)).click();
        VYTrackUtils.waitUntilLoaderScreenDissapear(driver);

        driver.findElement(By.cssSelector(calendarPage.repeatCheckBoxLocator)).click();
        List<String> expectedOptions= Arrays.asList("Daily", "Weekly", "Monthly","Yearly");

        List<String> actualOptions=calendarPage.getRepeatOptions();
        System.out.println(expectedOptions);
        System.out.println(actualOptions);

        Assert.assertEquals(actualOptions,expectedOptions);

    }

//    @Test
//    public void DailyRepeatOptionRepeatEveryTest(){
//
//    }


    // After Method is coming from TestBase

}
