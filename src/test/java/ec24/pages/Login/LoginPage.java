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

    @FindBy (xpath = "//h2[text()='Returning Customer']")
    private WebElement loginTitle;

    public void enterAccount (String emailAddress, String pass){
        email.sendKeys(emailAddress);
        password.sendKeys(pass);
    }
    public void enterEmail (String emailAddress){
        email.sendKeys(emailAddress);
    }
    public void enterPassword (String pass){
        password.sendKeys(pass);
    }

    public void clickLogin(){
        submitBtn.click();
    }

    public boolean loginOptionIsDisplayed() {
        return loginOption.isDisplayed();
    }
    public String getTitlePage(){
        return loginTitle.getText();
    }

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
