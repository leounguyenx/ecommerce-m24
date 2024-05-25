package ec24.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-firstname")
    private WebElement fname;
    @FindBy(id = "input-lastname")
    private WebElement lname;
    @FindBy(id = "input-email")
    private WebElement email;
    @FindBy(id = "input-telephone")
    private WebElement phone;
    @FindBy(id = "input-password")
    private WebElement password;
    @FindBy(id = "input-confirm")
    private WebElement confirmPassword;
    @FindBy(xpath = "(//input[@name='newsletter'])[1]")
    private WebElement yesOption;
    @FindBy(xpath = "(//input[@name='newsletter'])[2]")
    private WebElement noOption;
    @FindBy(xpath = "//input[@name='agree']")
    private WebElement policyCheckbox;
    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement submitBtn;
    @FindBy (linkText = "login page")
    private WebElement backToLoginPage;
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    private WebElement successText;

    public void fillFullRegisterForm(String firstName, String lastName, String registerEmail, String telephone, String pass, String confirmPass, int yOn) {
        fname.sendKeys(firstName);
        lname.sendKeys(lastName);
        email.sendKeys(registerEmail);
        phone.sendKeys(telephone);
        password.sendKeys(pass);
        confirmPassword.sendKeys(confirmPass);
        if (yOn == 1){
            yesOption.click();
        }
        policyCheckbox.click();
    }

    public void fillFullRegisterForm(String firstName, String lastName, String registerEmail, String telephone, String pass, String confirmPass) {
        fname.sendKeys(firstName);
        lname.sendKeys(lastName);
        email.sendKeys(registerEmail);
        phone.sendKeys(telephone);
        password.sendKeys(pass);
        confirmPassword.sendKeys(confirmPass);
        policyCheckbox.click();
    }

    public void enterFirstName(String firstName){
        fname.sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        lname.sendKeys(lastName);
    }
    public void enterEmail(String registerEmail){
        email.sendKeys(registerEmail);
    }
    public void enterTelephone(String telephone){
        phone.sendKeys(telephone);
    }
    public void enterPass(String pass){
        password.sendKeys(pass);
    }
    public void enterConfirmPass(String confirmPass){
        confirmPassword.sendKeys(confirmPass);
    }
    public void subscribeNews(int yOn){
        if (yOn == 1){
            yesOption.click();
        } else {
            noOption.click();
        }
    }
    public void clickPrivacyCheckbox() {
        policyCheckbox.click();
    }
    public String getSuccessText(){
        return successText.getText();
    }
    public void clickRegister() {
        submitBtn.click();
    }
}
