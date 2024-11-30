package pages;

import org.openqa.selenium.By;

public class AdminRegistrationPage extends BasePage{
    public String adminRegistrationPageUrl = "https://app.klasio.dev/registration";
    public By firstName = By.id("form.first_name");
    public By lastName = By.id("form.last_name");
    public By emailField = By.id("form.email");
    public By passwordField = By.id("form.password");
    public By repeatPasswordField = By.id("form.password_confirmation");
    public By termsAndConditionCheckBox = By.id("form.terms");
    public By ContinueButton = By.xpath("//button[@type='submit']");
    public By logInLink = By.linkText("Login");
    public String emailAlreadyExistWarningMsg = "Email address already exists.";
    public String lastNameRequiredWarningMsg = "Last name is required.";
    public String passwordNotMatchWarningMsg = "Password does not match.";
    public String termAndConditionNotAcceptWarningMsg = "You must agree to the terms and conditions.";
    public String emailFieldRequiredMsg = "The form.email field is required.";
    public By lastNameRequireWarningElement = By.xpath("//p[contains(text(),'Last name is required.')]");
    public By emailAlreadyExistWarningElement = By.xpath("//p[contains(text(),'Email address already exists.')]");
    public By passwordNotMatchWarningElement = By.xpath("//p[contains(text(),'Password does not match.')]");
    public By termAndConditionNotAcceptWarningElement = By.xpath("//p[contains(text(),'You must agree to the terms and conditions.')]");
    public By emailFieldRequiredElement = By.xpath("//p[contains(text(),'The form.email field is required.')]");
    public By termsAndConditionLinkElement = By.linkText("Terms & Conditions");
}
