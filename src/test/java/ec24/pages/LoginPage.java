package ec24.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;
    static String url = "https://tutorialsninja.com/demo/index.php?route=account/login";
    @FindBy(id = "input-email")
    private WebElement email;

    @FindBy(id = "input-password")
    private WebElement password;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginBtn;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement warningMessage;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement successMessage;

    @FindBy(linkText = "Forgotten Password")
    private WebElement forgettenPassword;

    public void enterAccount (String user, String pass){
        email.sendKeys(user);
        password.sendKeys(pass);
    }

    public void clickLogin(){
        loginBtn.click();
    }

    public String getWarningMessage() {
        return warningMessage.getText();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public void clickForgetPassword() {
        forgettenPassword.click();
    }

    public void resetPassword(String targetEmail) {
        email.sendKeys(targetEmail);
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
    }

    public LoginPage(WebDriver driver){
        //driver.navigate().to(url);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
