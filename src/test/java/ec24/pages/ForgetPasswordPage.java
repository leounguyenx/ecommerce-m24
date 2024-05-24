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

    public void clickForgetPassword() {
        forgettenPassword.click();
    }

    public void resetPassword(String targetEmail) {
        email.sendKeys(targetEmail);
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
    }
}
