package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.ArrayList;

import static pages.Constants.*;

public class SocialMediaLinksTests extends BaseTest{


    /*Checking on Facebook link from page footer
    1. Navigate to Jasmin.rs
    2. Click on Facebook link

    Expected results :
    2. Verify that we are on Jasmin Facebook page and then switched to Jasmin home page
     */

    @Test
    public void facebookLinkTest() {
        ChromeDriver driver = openChromeDriver();
        try{
            HomePage homePage = new HomePage(driver);
            homePage.clickFacebookLink();
            ArrayList<String> tabs = new ArrayList (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            print("Verify that we are on Jasmin Facebook page");
            String currentUrl = driver.getCurrentUrl();
            assert currentUrl.equals(JASMIN_FACEBOOK_URL);
            driver.close();

            print("Switch to Jasmin.rs page");
            driver.switchTo().window(tabs.get(0));

            print("Verify that we are on Jasmin home page again");
            currentUrl = driver.getCurrentUrl();
            assert currentUrl.equals(JASMIN_URL);

        }finally {
            driver.quit();
        }
    }

    /*Checking on YouTube link from page footer
    1. Navigate to Jasmin.rs
    2. Click on YouTube link

    Expected results :
    2. Verify that we are on Jasmin YouTube channel and then switched to Jasmin home page
     */


    @Test
    public void youTubeLinkTest() {
        ChromeDriver driver = openChromeDriver();
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickYouTubeLink();
            ArrayList<String> tabs = new ArrayList (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            print("Verify that we are on Jasmin YouTube channel");
            String currentUrl = driver.getCurrentUrl();
            assert currentUrl.equals(YOU_TUBE_URL);
            driver.close();

            print("Switch to Jasmin.rs page");
            driver.switchTo().window(tabs.get(0));

            print("Verify that we are on Jasmin home page again");
            currentUrl = driver.getCurrentUrl();
            assert currentUrl.equals(JASMIN_URL);

        }finally {
            driver.quit();
        }
    }

}
