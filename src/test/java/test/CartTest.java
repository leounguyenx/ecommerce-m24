package test;

import ec24.base.BaseClass;
import ec24.managers.MessageManager;
import ec24.managers.WaitManager;
import ec24.pages.CartPage;
import ec24.pages.HomePage;
import ec24.pages.Login.LoginPage;
import ec24.pages.Login.LogoutPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class CartTest {
    WebDriver driver;

    CartPage cp;
    MessageManager mm;
    WaitManager wm;


    @BeforeTest
    public void setUp() {
        driver = BaseClass.headlessInit();
        wm = new WaitManager(driver);
        wm.setImplicitWait(10);


        cp = new CartPage(driver);
    }

    //Verify that User can go to the Cart Page by clicking on Cart icon on the top right header of the page
    @Test
    public void testGoToCartPage() {
        cp.goToCartPage();
        assertTrue(cp.getPageTitle().equals("Shopping Cart"));
    }
    //Verify that User can see a dropdown menu when click on Cart button next to Search bar

    //Verify that User can see the dropdown with message "Your shopping cart is empty!" by default
    @Test
    public void testShowEmptyMessageWithDefaultCart() {
        cp.clickCartDropdown();
        assertTrue(cp.getPageTitle().equals("Your shopping cart is empty!"));
    }
    //Verify that User can see the list of products after adding products and clicking on Cart button next to Search bar

    //Verify that User can go Cart Page when clicking on "View Cart" on dropdown menu

    //Verify that User can go Product Detail Page when clicking on the image of the Cart List

    //Verify that User can go Product Detail Page when clicking on the product's name of the Cart List

    //Verify that User can delete selected products when clicking on Remove icon button on dropdown menu

    //Verify that User can check out when clicking on "Checkout" on dropdown menu

    //Verify that User can update the quantity of a selected product

    //Verify that User can remove the selected product

    /*TEST SCENARIOS*/


    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
