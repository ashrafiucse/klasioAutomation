package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.DriverSetup.getDriver;

public class BasePage {
    public WebElement getElement(By locator) {
        return waitForElementToBePresence(locator);
    }
    public void clickOnElement(By locator) {
        waitForElementToBeClickable(locator);
        getElement(locator).click();
    }

    public boolean isElementVisible(By locator) {
        return getElement(locator).isDisplayed();
    }

    public void sendKeysText(By locator,String inputText) {
        getElement(locator).clear();
        getElement(locator).sendKeys(inputText);
    }
    public WebElement waitForElementToBePresence(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void dropDownOptionSelectByIndex(By locator, String optionText) {
        Select select = new Select(getElement(locator));
        select.selectByVisibleText(optionText);
    }
    public String getElementText(By locator) {
        return getElement(locator).getText();
    }
}
