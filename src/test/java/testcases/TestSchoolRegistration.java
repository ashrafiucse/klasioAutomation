package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AdminLoginPage;
import pages.AdminRegistrationPage;
import utilities.DataSet;
import utilities.DriverSetup;

import static utilities.DataSet.adminLoginPageUrl;

public class TestSchoolRegistration extends DriverSetup {
    AdminLoginPage adminLoginPage = new AdminLoginPage();
    AdminRegistrationPage adminRegistrationPage = new AdminRegistrationPage();

    @Test(dataProvider = "adminRegistrationInvalidDataSet", dataProviderClass = DataSet.class)
    public void testRegistrationWithInvalidData(String firstName, String lastName, String emailAddress, String password, String confirmPassword) {
        getDriver().get(adminLoginPageUrl);
        adminLoginPage.clickOnElement(adminLoginPage.signUpLink);
        adminRegistrationPage.sendKeysText(adminRegistrationPage.firstName,firstName);
        adminRegistrationPage.sendKeysText(adminRegistrationPage.lastName,lastName);
        adminRegistrationPage.sendKeysText(adminRegistrationPage.emailField,emailAddress);
        adminRegistrationPage.sendKeysText(adminRegistrationPage.passwordField,password);
        adminRegistrationPage.sendKeysText(adminRegistrationPage.repeatPasswordField,confirmPassword);
        adminRegistrationPage.clickOnElement(adminRegistrationPage.termsAndConditionCheckBox);
        adminRegistrationPage.clickOnElement(adminRegistrationPage.ContinueButton);
        Assert.assertTrue(adminRegistrationPage.isElementVisible(adminRegistrationPage.ContinueButton));
    }

    @Test(dataProvider = "adminRegistrationValidDataSet", dataProviderClass = DataSet.class)
    public void testRegistrationWithoutAcceptingTermsAndConditions(String firstName, String lastName, String emailAddress, String password, String confirmPassword) {
        getDriver().get(adminLoginPageUrl);
        adminLoginPage.clickOnElement(adminLoginPage.signUpLink);
        adminRegistrationPage.sendKeysText(adminRegistrationPage.firstName,firstName);
        adminRegistrationPage.sendKeysText(adminRegistrationPage.lastName,lastName);
        adminRegistrationPage.sendKeysText(adminRegistrationPage.emailField,emailAddress);
        adminRegistrationPage.sendKeysText(adminRegistrationPage.passwordField,password);
        adminRegistrationPage.sendKeysText(adminRegistrationPage.repeatPasswordField,confirmPassword);
        adminRegistrationPage.clickOnElement(adminRegistrationPage.ContinueButton);
        Assert.assertTrue(adminRegistrationPage.isElementVisible(adminRegistrationPage.ContinueButton));
    }
}
