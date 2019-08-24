package com.cybertek.VyTrack;

import com.cybertek.utilities.SeleniumUtils;
import com.cybertek.utilities.TestBase;
import com.cybertek.utilities.VYTrackUtils;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class FindByTest extends TestBase {



    @Test
    public void test1(){
        locators.usernameIdLocator.sendKeys("salesmanager104");
        locators.passwordIdLocator.sendKeys("UserUser123", Keys.ENTER);
       // locators.loginButtonIdLocator.click();

        VYTrackUtils.waitUntilLoaderScreenDissapear(driver);

        action.moveToElement(locators.fleetLocator).perform();


        SeleniumUtils.waitPlease(3);
    }
}
