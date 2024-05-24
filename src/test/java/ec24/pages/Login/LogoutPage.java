package ec24.pages.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    WebDriver driver;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //@FindBy(xpath = "//a[text()='Logout']")
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    private WebElement logOutOption;
    public void clickLogout() {
        logOutOption.click();
    }
    public boolean checkLogoutDisplayed() {
        return logOutOption.isDisplayed();
    }
}
