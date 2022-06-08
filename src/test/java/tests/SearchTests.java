package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.CatalogSearchResultPage;
import pages.HomePage;

import static pages.Constants.INVALID_SEARCH_MESSAGE;


public class SearchTests extends BaseTest {

    /*Search Chloe Woman Edp parfem
    1. Navigate to Jasmin.rs
    2. Enter "Chloe Woman Edp" into search field
    3. Click on search button

    Expected results :
    3. Verify that actual item title contains item name that we searched for
     */

    @Test
    public void searchParfemTest() {
        ChromeDriver driver = openChromeDriver();
        String itemName = "CHLOE Woman Edp";
        try {

            HomePage homePage = new HomePage(driver);
            homePage.searchForItem(itemName);
            CatalogSearchResultPage catalogSearchResultPage = new CatalogSearchResultPage(driver);

            print("Verify that actual item title contains item name that we searched for");
            String actualItemTitle = catalogSearchResultPage.getSearchResultTitleText();
            assert actualItemTitle.contains(itemName): "Error: Wrong item title text. Expected " + itemName
                    + " .Actual " + actualItemTitle;

        } finally {
            driver.quit();
        }
    }


    /*Search with invalid data
    1. Navigate to Jasmin.rs
    2. Enter "abcd" into search field
    3. Click on search button

    Expected results :
    3. Verify that "Pretraga nije vratila rezultate" is shown
     */

    @Test
    public void invalidSearchTest(){
        ChromeDriver driver = openChromeDriver();
        String itemName = "abcd";
        try {

            HomePage homePage = new HomePage(driver);
            homePage.searchForItem(itemName);

            CatalogSearchResultPage catalogSearchResultPage = new CatalogSearchResultPage(driver);

            print("Verify that Pretraga nije vratila rezultate message is shown");
            String actualSearchMessage = catalogSearchResultPage.getInvalidSearchMessageText();
            assert actualSearchMessage.contains(INVALID_SEARCH_MESSAGE): "Error: Wrong search message.Expected: " +
                    INVALID_SEARCH_MESSAGE + ".Actual " + actualSearchMessage;
        }finally {
            driver.quit();

        }
    }
}






