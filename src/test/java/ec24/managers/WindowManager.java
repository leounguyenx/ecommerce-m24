package ec24.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WindowManager {
    WebDriver driver;
    public WindowManager(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getParentWindow() {
        return driver.getWindowHandle();
    }

    public String getCurrentWindow() {
        return driver.getWindowHandle();
    }

    //This will pass the control to the imminent parent frame of the current frame
    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }
}
