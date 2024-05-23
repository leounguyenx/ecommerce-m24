package ec24.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement myAccountDropdown;

    @FindBy(xpath = "//a[text()='Login']")
    private WebElement loginOption;

    @FindBy(xpath = "//a[text()='Register']")
    private WebElement registerOption;

    //@FindBy(xpath = "//a[text()='Logout']")
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    private WebElement logOutOption;

    public boolean checkLogoutDisplayed() {
        return logOutOption.isDisplayed();
    }

    public LoginPage goToLoginPage() {
        myAccountDropdown.click();
        loginOption.click();
        return new LoginPage(driver);
    }

    public HomePage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}