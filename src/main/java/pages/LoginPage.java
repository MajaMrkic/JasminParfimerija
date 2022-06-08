package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//h1[@class= 'page-title']")
    WebElement successfulLogoutMessage;

    @FindBy (id = "email")
    WebElement emailInputField;

    @FindBy (xpath = "//input[@name = 'login[password]']")
    WebElement passwordInputField;

    @FindBy (xpath = "//button[@class = 'action login primary']")
    WebElement submitButton;

    @FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    WebElement loginErrorMessage;


    public LoginPage(ChromeDriver driver){
        super(driver);
        print("Login Page");
    }

    public String getSuccessfulLogoutMessageText(){
        return successfulLogoutMessage.getText();
    }


    public void enterEMail(String eMail){
        print("Enter e-mail");
        emailInputField.click();
        emailInputField.sendKeys(eMail);
    }

    public void enterPassword(String password){
        print("Enter password");
        passwordInputField.click();
        passwordInputField.sendKeys(password);
    }

    public void clickSubmitButton(){
        print("Click submit button");
        submitButton.click();
    }

    public String getLoginErrorMessageText(){return loginErrorMessage.getText();
    }


}
