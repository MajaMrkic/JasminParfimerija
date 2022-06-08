package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{


    @FindBy (id = "search")
    WebElement searchField;

    @FindBy (xpath = "//button[@class = 'amsearch-loupe']")
    WebElement searchButton;

    @FindBy (xpath = "//a[@href = 'https://www.jasmin.rs/sminka.html']")
    WebElement sminkaMenuOption;

    @FindBy (xpath = "//a[@href = 'https://www.jasmin.rs/sminka/lice.html']")
    WebElement liceSubMenuOption;

    @FindBy (xpath = "//a[@href = 'https://www.jasmin.rs/sminka/lice/korektori.html']")
    WebElement korektoriSubSubMenuOption;


    public HomePage(ChromeDriver driver) {
        super(driver);
        driver.get("https://www.jasmin.rs/");
        print("Home Page");

    }

    public void enterTextIntoSearchField(String text){
        searchField.sendKeys(text);
    }

    public void searchForItem(String text) {
        print("Enter item name into search field");
        enterTextIntoSearchField(text);
        waitForElement(searchButton);
        print("Click on search button");
        searchButton.click();
    }

    public void chooseKorektoriFromSubMenu() {
        print("Hoover over Sminka menu option");
        hoverOverElement(sminkaMenuOption);
        print("Hoover over Lice submenu option");
        hoverOverElement(liceSubMenuOption);
        print("Hoover over Korektori subsubmenu option");
        hoverOverElement(korektoriSubSubMenuOption);
        print("Click on Korektori subsubmenu option");
        korektoriSubSubMenuOption.click();
    }
}
