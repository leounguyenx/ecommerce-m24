package ec24.pages.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;
    //static String url = "https://tutorialsninja.com/demo/index.php?route=account/login";
    @FindBy(id = "input-email")
    private WebElement email;

    @FindBy(id = "input-password")
    private WebElement password;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement submitBtn;

    @FindBy(xpath = "(//a[text()=\"Login\"])[2]")
    private WebElement loginOption;

    public void enterAccount (String user, String pass){
        email.sendKeys(user);
        password.sendKeys(pass);
    }

    public void clickLogin(){
        submitBtn.click();
    }

    public boolean loginOptionIsDisplayed() {
        return loginOption.isDisplayed();
    }

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
