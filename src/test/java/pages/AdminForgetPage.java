package pages;

import org.openqa.selenium.By;

public class AdminForgetPage extends BasePage{
    public String forgetPageUrl = "https://app.klasio.dev/forgot-password";
    public String successMessageText = "We have emailed your password reset link.";
    public By emailInputField = By.id("email");
    public By successMessageTextElement = By.xpath("//*[contains(text(),'We have emailed your password reset link.')]");
    public By sendResetLinkButton = By.xpath("//button[@type='submit']");
    public By backToLoginPageLink = By.linkText("Back to Login");
}
