package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import utilities.DriverSetup;

import static utilities.DataSet.*;

public class TestAdminLoginPage extends DriverSetup {
    AdminLoginPage adminLoginPage = new AdminLoginPage();
    AdminForgetPage adminForgetPage = new AdminForgetPage();
    AdminRegistrationPage adminRegistrationPage = new AdminRegistrationPage();
    AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();

    @BeforeMethod
    public void navigateToAdminLoginPage() {
        getDriver().get(adminLoginPageUrl);
    }

    @Test
    void testLoginPageLoadSuccessfully() {
        Assert.assertEquals(getDriver().getCurrentUrl(),adminLoginPageUrl);

    }

    @Test
    void testForgetPasswordPageRedirectSuccessfully() {
        adminLoginPage.clickOnElement(adminLoginPage.forgotPasswordLink);
        Assert.assertEquals(getDriver().getCurrentUrl(),adminForgetPage.forgetPageUrl);
    }

    @Test
    void testRegistrationPageLoadSuccessfully() {
        adminLoginPage.clickOnElement(adminLoginPage.signUpLink);
        Assert.assertEquals(getDriver().getCurrentUrl(),adminRegistrationPage.adminRegistrationPageUrl);
    }

    @Test
    void testLoginWithValidCredentials() {
        adminLoginPage.doLogin(ownerEmailAddress, ownerPassword);
    }

    @Test
    void testLoginWithInvalidCredentials() {
        adminLoginPage.sendKeysText(adminLoginPage.emailInputField,"instructor@khanacademy.com");
        adminLoginPage.sendKeysText(adminLoginPage.passwordInputField,"1234567890");
        adminLoginPage.clickOnElement(adminLoginPage.logInButton);
        Assert.assertEquals(adminLoginPage.getElement(adminLoginPage.warningMessage).getText(),adminLoginPage.warningMessageText);
    }
}
