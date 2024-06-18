package test;

import ec24.base.BaseClass;
import ec24.pages.HomePage;
import ec24.pages.Login.LoginPage;
import ec24.managers.EmailManager;
import ec24.managers.MessageManager;
import ec24.managers.WaitManager;
import ec24.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class RegisterTest {
    WebDriver driver;
    LoginPage lp;
    HomePage hp;
    WaitManager wm;
    EmailManager em;
    MessageManager mm;
    RegisterPage rp;
    String email;
    String parentWindow;

    @BeforeMethod
    public void setUp() {
        driver = BaseClass.headlessInit();
        wm = new WaitManager(driver);
        wm.setImplicitWait(10);
        parentWindow = driver.getWindowHandle();

        hp = new HomePage(driver);
        lp = new LoginPage(driver);
        em = new EmailManager(driver);
        rp = new RegisterPage(driver);
        mm = new MessageManager(driver);

    }

    @Test (priority = 1)
    public void testRegisterSuccessful() {
        hp.goToRegisterPage();
        email = em.fetchRandomEmail();
        driver.switchTo().window(parentWindow);
        rp.fillFullRegisterForm("John", "Deep", email, "4342889654", "1234", "1234");
        rp.clickRegister();
        Assert.assertEquals(rp.getSuccessText(), "Your Account Has Been Created!");
    }

    @Test (priority = 2)
    public void testRegisterWithExistEmail() {
        hp.goToRegisterPage();
        email = "tbonguyen75@gmail.com";
        driver.switchTo().window(parentWindow);
        rp.fillFullRegisterForm("John", "Deep", email, "4342889654", "1234", "1234");
        rp.clickRegister();
        Assert.assertEquals(mm.getWarningMessage(), "Warning: E-Mail Address is already registered!");
    }

    //Enter one of the fields then click Back => Should show confirm box


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
