package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminForgetPage;
import pages.AdminLoginPage;
import utilities.DriverSetup;

public class TestForgetPasswordPage extends DriverSetup {
    AdminForgetPage adminForgetPage = new AdminForgetPage();
    AdminLoginPage adminLoginPage = new AdminLoginPage();

    @Test
    void testForgetPassword() {
        getDriver().get(adminForgetPage.forgetPageUrl);
        adminForgetPage.sendKeysText(adminForgetPage.emailInputField,"khanacademy@gmail.com");
        adminForgetPage.clickOnElement(adminForgetPage.sendResetLinkButton);
        Assert.assertEquals(adminForgetPage.getElement(adminForgetPage.successMessageTextElement).getText(),adminForgetPage.successMessageText);
    }

    @Test
    void testBackToLoginPageLink() {
        getDriver().get(adminForgetPage.forgetPageUrl);
        adminForgetPage.clickOnElement(adminForgetPage.backToLoginPageLink);
        Assert.assertEquals(getDriver().getCurrentUrl(),adminLoginPage.logInPageUrl);
    }
}
