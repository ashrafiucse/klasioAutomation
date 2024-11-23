package pages;

import org.openqa.selenium.By;

public class AdminLoginPage extends BasePage{
    public String logInPageUrl = "https://app.klasio.dev/login";
    public String warningMessageText = "These credentials do not match our records.";
    public By emailInputField = By.id("email");
    public By passwordInputField = By.id("password");
    public By logInButton = By.xpath("//button[@type='submit']");
    public By forgotPasswordLink = By.linkText("Forgot password?");
    public By signUpLink = By.linkText("Sign Up");
    public By warningMessage = By.xpath("//*[contains(text(),'These credentials do not match our records.')]");
}
