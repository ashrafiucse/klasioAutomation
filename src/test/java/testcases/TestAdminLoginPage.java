package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.DriverSetup;

public class TestAdminLoginPage extends DriverSetup {
    AdminLoginPage adminLoginPage = new AdminLoginPage();
    AdminForgetPage adminForgetPage = new AdminForgetPage();
    AdminRegistrationPage adminRegistrationPage = new AdminRegistrationPage();
    AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();

    @Test
    void testLoginPageLoadSuccessfully() {
        getDriver().get(adminLoginPage.logInPageUrl);
        Assert.assertEquals(getDriver().getCurrentUrl(),adminLoginPage.logInPageUrl);

    }

    @Test
    void testForgetPasswordPageRedirectSuccessfully() {
        getDriver().get(adminLoginPage.logInPageUrl);
        adminLoginPage.clickOnElement(adminLoginPage.forgotPasswordLink);
        Assert.assertEquals(getDriver().getCurrentUrl(),adminForgetPage.forgetPageUrl);
    }

    @Test
    void testRegistrationPageLoadSuccessfully() {
        getDriver().get(adminLoginPage.logInPageUrl);
        adminLoginPage.clickOnElement(adminLoginPage.signUpLink);
        Assert.assertEquals(getDriver().getCurrentUrl(),adminRegistrationPage.adminRegistrationPageUrl);
    }

    @Test
    void testLoginWithValidCredentials() {
        getDriver().get(adminLoginPage.logInPageUrl);
        adminLoginPage.sendKeysText(adminLoginPage.emailInputField,"instructor@khanacademy.com");
        adminLoginPage.sendKeysText(adminLoginPage.passwordInputField,"123456789");
        adminLoginPage.clickOnElement(adminLoginPage.logInButton);
        Assert.assertEquals(getDriver().getCurrentUrl(),adminDashBoardPage.adminDashBoardUrl);
    }

    @Test
    void testLoginWithInvalidCredentials() {
        getDriver().get(adminLoginPage.logInPageUrl);
        adminLoginPage.sendKeysText(adminLoginPage.emailInputField,"instructor@khanacademy.com");
        adminLoginPage.sendKeysText(adminLoginPage.passwordInputField,"1234567890");
        adminLoginPage.clickOnElement(adminLoginPage.logInButton);
        Assert.assertEquals(adminLoginPage.getElement(adminLoginPage.warningMessage).getText(),adminLoginPage.warningMessageText);
    }
}
