package test;

import ec24.base.BaseClass;
import ec24.pages.HomePage;
import ec24.pages.Login.LoginPage;
import ec24.pages.Login.LogoutPage;
import ec24.pages.manager.WaitManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class LogoutTest {
    WebDriver driver;
    LoginPage lp;
    HomePage hp;
    LogoutPage lop;
    WaitManager wm;

    String user = "tbonguyen75@gmail.com";
    String pass = "1234";

    @BeforeTest
    public void setUp() {
        driver = BaseClass.headlessInit();
        wm = new WaitManager(driver);
        wm.setImplicitWait(10);

        hp = new HomePage(driver);
        lp = new LoginPage(driver);
        lop = new LogoutPage(driver);
    }
    @Test
    public void testLogoutSuccessful() throws InterruptedException {

        hp.goToLoginPage();
        lp.enterAccount(user, pass);
        lp.clickLogin();

        lop.clickLogout();
        Thread.sleep(Duration.ofSeconds(2));
        Assert.assertTrue(lp.loginOptionIsDisplayed());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
