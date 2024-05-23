package test;

import ec24.base.BaseClass;
import ec24.pages.HomePage;
import ec24.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;
    LoginPage lp;
    HomePage hp;
    String user;
    String pass;

    @BeforeTest
    public void setUp() {
        driver= BaseClass.init();
        hp=new HomePage(driver);
        lp=new LoginPage(driver);
    }

    @Test
    public void validLogin() {
        //Valid Credential
        user = "tbonguyen75@gmail.com";
        pass = "1234";

        hp.goToLoginPage();
        lp.enterAccount(user, pass);
        lp.clickLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertTrue(hp.checkLogoutDisplayed());
    }

    @Test
    public void invalidLogin() {
        //Invalid Credential
        user = "tbonguyen75gmail.com";
        pass = "1234";

        hp.goToLoginPage();
        lp.enterAccount(user, pass);
        lp.clickLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertEquals(lp.getWarningMessage(), "Warning: No match for E-Mail Address and/or Password.");
    }

    @Test
    public void testForgetPasswordWithValidEmail() {
        String targetEmail = "tbonguyen75@gmail.com";

        hp.goToLoginPage();
        lp.clickForgetPassword();
        lp.resetPassword(targetEmail);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertEquals(lp.getSuccessMessage(), "An email with a confirmation link has been sent your email address.");
    }

    @Test
    public void testForgetPasswordWithInValidEmail() {
        String targetEmail = "tbonguyen@gmail.com";

        hp.goToLoginPage();
        lp.clickForgetPassword();
        lp.resetPassword(targetEmail);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertEquals(lp.getWarningMessage(), "Warning: The E-Mail Address was not found in our records, please try again!");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
