package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    ChromeDriver driver = null;


    @FindBy (xpath = "//a[contains(@href, 'youtube')]")
    WebElement youTubeLink;

    @FindBy (xpath = "//a[contains(@href, 'facebook')]")
    WebElement facebookLink;

    @FindBy (xpath = "//div[@class='header-holder']")
    WebElement mojJasminAccountLabel;
    
    @FindBy(xpath = "//*[@id='html-body']/div[2]/header/div[2]/div[3]/ul/li[1]/span")
    WebElement loggedInWelcomeMessage;

    @FindBy(xpath = "//li[@class='customer-welcome']")
    WebElement loggedInOptions;

    @FindBy (xpath = "//a[contains(@href, 'login/referer')]")
    WebElement prijaviSeButton;

    @FindBy(xpath = "//div[@class='customer-menu']//a[contains(@href, 'account/logout')]")
    WebElement odjaviSeButton;



    public BasePage(ChromeDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickOnMojJasminAccountLabel(){
        print("Click MojJasmin account");
        mojJasminAccountLabel.click();
    }

    public void clickOnPrijaviSeButton(){
        print("Click on Prijavi se button");
        prijaviSeButton.click();
    }

    public void clickOnOdjaviSeButton(){
        print("Click on Odjavi se button");
        odjaviSeButton.click();
    }

    public void clickOnLoggedinOptions(){
        print("Click on loggedin options");
        loggedInOptions.click();
    }

    public String getLoggedInWelcomeMessageText(){
        return loggedInWelcomeMessage.getText();
    }


    public void clickYouTubeLink(){
        print("Click YouTube Link");
        scrollToElement(youTubeLink);
        youTubeLink.click();
    }

    public void clickFacebookLink(){
        print("Click Facebook Link");
        scrollToElement(facebookLink);
        facebookLink.click();
    }

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);" ,element);
    }

    public void sleep () {
        try {
            Thread.sleep(5000);
        }catch (Exception e) {
            print(e.getMessage());
        }
    }

    public static void print(String s) {
        System.out.println(s);
    }
}
