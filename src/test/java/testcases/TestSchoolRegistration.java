package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AdminLoginPage;
import pages.AdminNewSchoolCreationPage;
import pages.AdminRegistrationPage;
import pages.AdminRegistrationTermsAndConditionPage;
import utilities.DataSet;
import utilities.DriverSetup;

import static utilities.DataSet.*;

public class TestSchoolRegistration extends DriverSetup {
    AdminLoginPage adminLoginPage = new AdminLoginPage();
    AdminRegistrationPage adminRegistrationPage = new AdminRegistrationPage();
    AdminRegistrationTermsAndConditionPage adminRegistrationTermsAndConditionPage = new AdminRegistrationTermsAndConditionPage();
    AdminNewSchoolCreationPage adminNewSchoolCreationPage = new AdminNewSchoolCreationPage();

    @Test
    public void testTermsAndConditionsLink() {
        getDriver().get(adminLoginPageUrl);
        adminLoginPage.clickOnElement(adminLoginPage.signUpLink);
        adminRegistrationPage.clickOnElement(adminRegistrationPage.termsAndConditionLinkElement);
        Assert.assertTrue(adminRegistrationPage.isElementVisible(adminRegistrationTermsAndConditionPage.termsAndConditionTitleTextElement));
    }

    @Test
    public void testLogInLinkInRegistrationPage() {
        getDriver().get(adminLoginPageUrl);
        adminLoginPage.clickOnElement(adminLoginPage.signUpLink);
        adminRegistrationPage.clickOnElement(adminRegistrationPage.logInLink);
        Assert.assertTrue(adminLoginPage.isElementVisible(adminLoginPage.emailInputField));
        Assert.assertTrue(adminLoginPage.isElementVisible(adminLoginPage.passwordInputField));
        Assert.assertTrue(adminLoginPage.isElementVisible(adminLoginPage.logInButton));
    }


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

    @Test(dataProvider = "adminRegistrationWithExistingAccountEmail", dataProviderClass = DataSet.class)
    public void testWithExistingAccountEmail(String firstName, String lastName, String emailAddress, String password, String confirmPassword) {
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
        Assert.assertTrue(adminRegistrationPage.isElementVisible(adminRegistrationPage.firstName));

    }

    @Test
    public void testRegistrationWithValidFields() {
        getDriver().get(adminLoginPageUrl);
        adminLoginPage.clickOnElement(adminLoginPage.signUpLink);
        adminRegistrationPage.sendKeysText(adminRegistrationPage.firstName, ownerFirstName);
        adminRegistrationPage.sendKeysText(adminRegistrationPage.lastName, ownerLastName);
        adminRegistrationPage.sendKeysText(adminRegistrationPage.emailField, ownerEmailAddress);
        adminRegistrationPage.sendKeysText(adminRegistrationPage.passwordField, ownerPassword);
        adminRegistrationPage.sendKeysText(adminRegistrationPage.repeatPasswordField, ownerPassword);
        adminRegistrationPage.clickOnElement(adminRegistrationPage.termsAndConditionCheckBox);
        adminRegistrationPage.clickOnElement(adminRegistrationPage.ContinueButton);
        Assert.assertTrue(adminNewSchoolCreationPage.isElementVisible(adminNewSchoolCreationPage.onlineAcademyOption));
    }

    @Test
    public void testSignUpWithSelectingSchoolType() {
        testRegistrationWithValidFields();
        adminNewSchoolCreationPage.clickOnElement(adminNewSchoolCreationPage.onlineAcademyOption);
        adminNewSchoolCreationPage.clickOnElement(adminNewSchoolCreationPage.continueButton);

    }



}
