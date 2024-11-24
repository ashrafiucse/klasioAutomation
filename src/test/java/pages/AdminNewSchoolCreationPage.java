package pages;

import org.openqa.selenium.By;

public class AdminNewSchoolCreationPage extends BasePage{
    public String newSchoolPageUrl = "https://app.klasio.dev/new-school";
    public By onlineAcademyOption = By.id("radio1");
    public By professionalOption = By.id("radio2");
    public By educationInstituteOption = By.id("radio3");
    public By organizationOption = By.id("radio4");
    public By continueButton = By.xpath("//button[contains(text(),'Continue')]");
    public By schoolNameInputField = By.id("schoolName");
    public By schoolDesiredSubDomain = By.id("subdomain");
    public By goBackButton = By.xpath("//button[contains(text(),'Go Back')]");

    public String subDomainAvailableTextMsg = "Subdomain available.";
    public By subAvailableMsgElement = By.xpath("//*[contains(text(),'Subdomain available.')]");
    public String subDomainAlreadyTakenMsg = "The subdomain has already been taken.";

}
