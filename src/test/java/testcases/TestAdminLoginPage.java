package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.DriverSetup;

import static utilities.DataSet.adminLoginPageUrl;

public class TestAdminLoginPage extends DriverSetup {
    AdminLoginPage adminLoginPage = new AdminLoginPage();
    AdminForgetPage adminForgetPage = new AdminForgetPage();
    AdminRegistrationPage adminRegistrationPage = new AdminRegistrationPage();
    AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();

    @Test
    void testLoginPageLoadSuccessfully() {
        getDriver().get(adminLoginPageUrl);
        Assert.assertEquals(getDriver().getCurrentUrl(),adminLoginPageUrl);

    }

    @Test
    void testForgetPasswordPageRedirectSuccessfully() {
        getDriver().get(adminLoginPageUrl);
        adminLoginPage.clickOnElement(adminLoginPage.forgotPasswordLink);
        Assert.assertEquals(getDriver().getCurrentUrl(),adminForgetPage.forgetPageUrl);
    }

    @Test
    void testRegistrationPageLoadSuccessfully() {
        getDriver().get(adminLoginPageUrl);
        adminLoginPage.clickOnElement(adminLoginPage.signUpLink);
        Assert.assertEquals(getDriver().getCurrentUrl(),adminRegistrationPage.adminRegistrationPageUrl);
    }

    @Test
    void testLoginWithValidCredentials() {
        getDriver().get(adminLoginPageUrl);
        adminLoginPage.sendKeysText(adminLoginPage.emailInputField,"instructor@khanacademy.com");
        adminLoginPage.sendKeysText(adminLoginPage.passwordInputField,"123456789");
        adminLoginPage.clickOnElement(adminLoginPage.logInButton);
        Assert.assertEquals(getDriver().getCurrentUrl(),adminDashBoardPage.adminDashBoardUrl);
    }

    @Test
    void testLoginWithInvalidCredentials() {
        getDriver().get(adminLoginPageUrl);
        adminLoginPage.sendKeysText(adminLoginPage.emailInputField,"instructor@khanacademy.com");
        adminLoginPage.sendKeysText(adminLoginPage.passwordInputField,"1234567890");
        adminLoginPage.clickOnElement(adminLoginPage.logInButton);
        Assert.assertEquals(adminLoginPage.getElement(adminLoginPage.warningMessage).getText(),adminLoginPage.warningMessageText);
    }
}
