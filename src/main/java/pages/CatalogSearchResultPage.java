package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class CatalogSearchResultPage extends BasePage {

    @FindBy (css = "[data-ui-id='page-title-wrapper']")
    WebElement searchResultTitle;

    @FindBy (xpath = "//div[@class='message notice']/div")
    WebElement invalidSearchMessage;


    public CatalogSearchResultPage(ChromeDriver driver){
        super(driver);
        print("Catalog Search Result Page");
    }

    public String getSearchResultTitleText() {
        return searchResultTitle.getText();
    }

    public String getInvalidSearchMessageText(){
        return invalidSearchMessage.getText();
    }

}
