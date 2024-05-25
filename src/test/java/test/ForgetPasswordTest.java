package test;

import ec24.base.BaseClass;
import ec24.pages.ForgetPasswordPage;
import ec24.pages.HomePage;
import ec24.pages.Manager.MessageManager;
import ec24.pages.Manager.WaitManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ForgetPasswordTest {
    WebDriver driver;
    HomePage hp;
    ForgetPasswordPage fpp;
    MessageManager mm;
    WaitManager wm;
    String validEmail = "tbonguyen75@gmail.com";
    String invalidEmail = "tbonguyen@gmail.com";

    @BeforeTest
    public void setUp() {
        driver = BaseClass.headlessInit();
        wm = new WaitManager(driver);
        wm.setImplicitWait(10);

        hp = new HomePage(driver);
        fpp = new ForgetPasswordPage(driver);
        mm = new MessageManager(driver);
    }

    @Test
    public void testForgetPasswordWithValidEmail() {
        hp.goToLoginPage();
        fpp.clickForgetPassword();
        fpp.resetPassword(validEmail);
        Assert.assertEquals(mm.getSuccessMessage(), "An email with a confirmation link has been sent your email address.");
    }

    @Test
    public void testForgetPasswordWithInValidEmail() {
        hp.goToLoginPage();
        fpp.clickForgetPassword();
        fpp.resetPassword(invalidEmail);
        Assert.assertEquals(mm.getWarningMessage(), "Warning: The E-Mail Address was not found in our records, please try again!");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
