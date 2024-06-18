package ec24.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    WebDriver driver;

    public void MyAccountPage() {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
