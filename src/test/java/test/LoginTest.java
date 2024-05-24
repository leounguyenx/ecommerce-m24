package test;

import ec24.base.BaseClass;
import ec24.pages.HomePage;
import ec24.pages.Login.LoginPage;
import ec24.pages.Login.LogoutPage;
import ec24.pages.manager.MessageManager;
import ec24.pages.manager.WaitManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class LoginTest {
    WebDriver driver;

    LoginPage lp;
    HomePage hp;
    LogoutPage lop;
    MessageManager mm;
    WaitManager wm;

    String user;
    String pass;

    @BeforeTest
    public void setUp() {
        driver = BaseClass.headlessInit();
        wm = new WaitManager(driver);
        wm.setImplicitWait(10);

        hp = new HomePage(driver);
        lp = new LoginPage(driver);
        lop = new LogoutPage(driver);
        mm = new MessageManager(driver);

    }

    @Test
    public void validLogin() {
        //Valid Credential
        user = "tbonguyen75@gmail.com";
        pass = "1234";

        hp.goToLoginPage();
        lp.enterAccount(user, pass);
        lp.clickLogin();
        Assert.assertTrue(lop.checkLogoutDisplayed());
    }

    @Test
    public void invalidLogin() {
        //Invalid Credential
        user = "tbonguyen75gmail.com";
        pass = "1234";

        hp.goToLoginPage();
        lp.enterAccount(user, pass);
        lp.clickLogin();
        assertTrue(mm.getWarningMessage().equals("Warning: No match for E-Mail Address and/or Password.")
                || mm.getWarningMessage().equals("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour."));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
