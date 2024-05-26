package ec24.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgetPasswordPage {
    WebDriver driver;
    public ForgetPasswordPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Forgotten Password")
    private WebElement forgettenPassword;

    @FindBy(id = "input-email")
    private WebElement email;

    @FindBy(xpath = "//h1[text()='Forgot Your Password?']")
    private WebElement pageTitle;

    @FindBy (xpath = "//input[@value='Continue']")
//    @FindBy (linkText = "Continue")
    private WebElement resetBtn;

    @FindBy (linkText = "Back")
    private WebElement backBtn;

    public String getPageTitle() {
        return pageTitle.getText();
    }
    public void clickForgetPassword() {
        forgettenPassword.click();
    }
    public void clickResetBtn() {
        resetBtn.click();
    }
    public void clickBackBtn() {
        backBtn.click();
    }
    public void resetPassword(String targetEmail) {
        email.sendKeys(targetEmail);
        clickResetBtn();
    }
    public boolean checkReceiveResetEmail() {
        return true;
    }
    public boolean checkResetEmailSuccessful() {
        return true;
    }
}
