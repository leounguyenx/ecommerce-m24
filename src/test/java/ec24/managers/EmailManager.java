package ec24.managers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class EmailManager {
    WebDriver driver;
    WaitManager wait;
    @FindBy(id = "i-email")
    private WebElement email;
    String url = "https://tempmailo.com/";
    public EmailManager (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Fetch random email
    public String fetchRandomEmail() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(url);
//        String email = getEmail();

//        while (checkRegisteredEmail(email)){
//            //Check whether email is registed, refresh the page to get new email
//            driver.navigate().refresh();
//            email = getEmail();
//        }
        return getEmail();
    }

    public String getEmail() {
        wait = new WaitManager(driver);
        FluentWait<WebDriver> waitTime = wait.setFluentWait(20, 1);
        WebElement emailElement = waitTime.until(ExpectedConditions.visibilityOfElementLocated(By.id("i-email")));
        String email = emailElement.getAttribute("value");
        return email;
    }

    //NEED TO STORE LIST OF REGISTERED EMAIL INTO DB
//    public boolean checkRegisteredEmail(String email) {
//        //Check whether random email already exist then change the email
//        List<String> registedEmail = new ArrayList<>();
//        for (int i = 0; i < registedEmail.size(); i++){
//            if (registedEmail.get(i).equals(email)){
//                return true;
//            }
//        }
//        return false;
//    }

    /*
    * IDEA:
    * Fetch Random Mail -> Sign-up with fetched mail -> Store email into a db
    * Functionality:
    *       + Fetch Random Email (Unregistered email)
    *       + Use a registered email
    * */

}
