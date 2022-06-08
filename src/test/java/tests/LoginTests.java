package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static pages.Constants.*;

public class LoginTests extends BaseTest{

    /*Login with valid credentials
    1. Navigate to Jasmin.rs
    2. Click on My Jasmin account label
    3. Click on Prijavi se button
    4. Enter e-mail
    5. Enter password
    6. Click submit button

    Expected results :
    6. Verify that My Jasmin account label has text "Maja"
    */

    @Test
    public void validLoginTest()  {
        ChromeDriver driver = openChromeDriver();
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickOnMojJasminAccountLabel();
            homePage.clickOnPrijaviSeButton();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterEMail(USER_NAME);
            loginPage.enterPassword(PASSWORD);
            loginPage.clickSubmitButton();
            loginPage.sleep();

            String userAccountLabel = homePage.getLoggedInWelcomeMessageText();
            print("Verify that My Jasmin account label has text Maja");
            assert userAccountLabel.equals("Maja"): "Error: MyJasmin account label doesn't have text Maja. Expected" + USER_FIRST_NAME
                    + " .Actual " + userAccountLabel;


    }finally {
            driver.quit();
        }
    }

    /*Login with invalid user name
    1. Navigate to Jasmin.rs
    2. Click on My Jasmin account label
    3. Click on Prijavi se button
    4. Enter  invalid e-mail
    5. Enter password
    6. Click submit button

    Expected results :
    6. Verify that user is not logged in and "Email ili lozinka nisu ispravni. Pokušajte ponovo." message is shown
    */


    @Test
    public void invalidUserNameLoginTest() {
        ChromeDriver driver = openChromeDriver();
        try{
            HomePage homePage = new HomePage(driver);
            homePage.clickOnMojJasminAccountLabel();
            homePage.clickOnPrijaviSeButton();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterEMail(INVALID_USER_NAME);
            loginPage.enterPassword(PASSWORD);
            loginPage.clickSubmitButton();
            loginPage.sleep();

            String actualLoginErrorMessage = loginPage.getLoginErrorMessageText();
            print ("Verify that user is not logged in and Email ili lozinka nisu ispravni. Pokušajte ponovo. message is shown");
            assert actualLoginErrorMessage.equals(LOGIN_ERROR_MESSAGE) : "Error : Wrong error message. Expected :" + LOGIN_ERROR_MESSAGE
                    + " .Actual " + actualLoginErrorMessage;

         }finally {
            driver.quit();
        }
    }

    /*Logout test
    1. Navigate to Jasmin.rs
    2. Click on My Jasmin account label
    3. Click on Prijavi se button
    4. Enter e-mail
    5. Enter password
    6. Click submit button
    7. Click on loggedin options
    8. Click on Odjavi se button

    Expected results :
    8. Verify that "Uspešno ste se odjavili" message is shown
     */

    @Test
    public void logoutTest()  {
        ChromeDriver driver = openChromeDriver();
        try{
          HomePage homePage = new HomePage(driver);
            homePage.clickOnMojJasminAccountLabel();
            homePage.clickOnPrijaviSeButton();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterEMail(USER_NAME);
            loginPage.enterPassword(PASSWORD);
            loginPage.clickSubmitButton();
            loginPage.sleep();

            homePage.clickOnLoggedinOptions();
            homePage.clickOnOdjaviSeButton();

            String actualSuccessfulLogoutMessage = loginPage.getSuccessfulLogoutMessageText();
            print("Verify that Uspešno ste se odjavili message is shown");
            assert actualSuccessfulLogoutMessage.equals(SUCCESSFUL_LOGOUT_MESSAGE): "Error : Wrong message. Expected: " + SUCCESSFUL_LOGOUT_MESSAGE
                    + ".Actual " + actualSuccessfulLogoutMessage;
        }finally {
            driver.quit();
        }
    }



}
