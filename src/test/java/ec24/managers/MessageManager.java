package ec24.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MessageManager {
    WebDriver driver;
    public MessageManager (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement warningMessage;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement successMessage;

    @FindBy (xpath = "//div[@class='text-danger']")
    private List<WebElement> warningTextList;

    public String getWarningMessage() {
        return warningMessage.getText();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public List<WebElement> getWarningTextList() {
        return warningTextList;
    }
}
