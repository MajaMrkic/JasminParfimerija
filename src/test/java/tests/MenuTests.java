package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;

import static pages.Constants.SUBCATEGORY_KOREKTORI_URL;

public class MenuTests  extends BaseTest{

    /*Choose Korektori from main header menu
    1. Navigate to Jasmin.rs
    2. Hoover over Sminka menu option
    3. Hoover over Lice submenu option
    4. Hoover over Korektori subsubmenu option
    5. Click on Korektori subsubmenu option

    Expected results :
    5. Verify that url is correct
     */

    @Test
    public void chooseKorektoriFromMainHeaderMenuTest(){
        ChromeDriver driver = openChromeDriver();
        try{
            HomePage homePage = new HomePage(driver);
            homePage.chooseKorektoriFromSubMenu();

            String currentUrl = driver.getCurrentUrl();
            print("Verify that url is correct");
            assert currentUrl.equals(SUBCATEGORY_KOREKTORI_URL): "Wrong url. Expected :" + SUBCATEGORY_KOREKTORI_URL
            + " .Actual " + currentUrl;

        }finally {
            driver.quit();
        }
    }
}
