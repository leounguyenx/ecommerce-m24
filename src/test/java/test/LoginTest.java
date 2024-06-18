package test;

import ec24.base.BaseClass;
import ec24.pages.HomePage;
import ec24.pages.Login.LoginPage;
import ec24.pages.Login.LogoutPage;
import ec24.managers.MessageManager;
import ec24.managers.WaitManager;
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

    String validEmail;
    String invalidEmail;
    String unformatEmail;
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

        validEmail = "tbonguyen75@gmail.com";
        invalidEmail = "fullstacktester@gmail.com";
        unformatEmail = "email^ *%#-_+";
        pass = "1234";

    }

    @Test
    public void testGoToLoginPage(){
        hp.goToLoginPage();
        Assert.assertEquals(lp.getTitlePage(), "Returning Customer");
    }

    @Test
    public void testValidLogin() {
        hp.goToLoginPage();
        lp.enterAccount(validEmail, pass);
        lp.clickLogin();
        Assert.assertTrue(lop.checkLogoutDisplayed());
    }

    @Test
    public void testInvalidLogin() {
        hp.goToLoginPage();
        lp.enterAccount(invalidEmail, pass);
        lp.clickLogin();
        assertTrue(mm.getWarningMessage().equals("Warning: No match for E-Mail Address and/or Password.")
                || mm.getWarningMessage().equals("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour."));
    }

    @Test
    public void testLeaveAllFieldsBlank() {
        hp.goToLoginPage();
        lp.clickLogin();
        assertTrue(mm.getWarningMessage().equals("Warning: No match for E-Mail Address and/or Password.")
                || mm.getWarningMessage().equals("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour."));
    }

    @Test
    public void testBlankEmail() {
        hp.goToLoginPage();
        lp.enterPassword(pass);
        lp.clickLogin();
        assertTrue(mm.getWarningMessage().equals("Warning: No match for E-Mail Address and/or Password.")
                || mm.getWarningMessage().equals("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour."));
    }
    @Test
    public void testBlankPassword() {
        hp.goToLoginPage();
        lp.enterEmail(validEmail);
        lp.clickLogin();
        assertTrue(mm.getWarningMessage().equals("Warning: No match for E-Mail Address and/or Password.")
                || mm.getWarningMessage().equals("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour."));
    }
    @Test
    public void testEnterIncorrectEmail() {
        hp.goToLoginPage();
        lp.enterAccount(unformatEmail, pass);
        lp.clickLogin();
        assertTrue(mm.getWarningMessage().equals("Warning: No match for E-Mail Address and/or Password.")
                || mm.getWarningMessage().equals("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour."));
    }
    @Test
    public void testEnterIncorrectPassword() {
        hp.goToLoginPage();
        lp.enterAccount(validEmail, "0");
        lp.clickLogin();
        assertTrue(mm.getWarningMessage().equals("Warning: No match for E-Mail Address and/or Password.")
                || mm.getWarningMessage().equals("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour."));
    }

    @Test
    public void testLoginAfterResetPassword() {
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
