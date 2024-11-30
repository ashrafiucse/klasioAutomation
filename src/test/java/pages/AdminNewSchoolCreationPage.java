package pages;

import org.openqa.selenium.By;

public class AdminNewSchoolCreationPage extends BasePage{
    public String newSchoolPageUrl = "https://app.klasio.dev/new-school";
    public By onlineAcademyOption = By.xpath("//label[@for='radio1']");
    public By professionalOption = By.xpath("//label[@for='radio2']");
    public By educationInstituteOption = By.xpath("//label[@for='radio3']");
    public By organizationOption = By.xpath("//label[@for='radio4']");
    public By continueButton = By.xpath("//button[normalize-space()='Continue']");
    public By schoolNameInputField = By.id("schoolName");
    public By schoolDesiredSubDomain = By.id("subdomain");
    public By goBackButton = By.xpath("//button[contains(text(),'Go Back')]");

    public String subDomainAvailableTextMsg = "Subdomain available.";
    public By subAvailableMsgElement = By.xpath("//*[contains(text(),'Subdomain available.')]");
    public String subDomainAlreadyTakenMsg = "The subdomain has already been taken.";

}
