package ec24.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.xml.xpath.XPath;

public class CartPage {
    WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "cart")
    private WebElement cartButton;
    @FindBy(xpath = "//a[@title='Shopping Cart']")
    private WebElement cartIcon;
    @FindBy(xpath = "//*[@id=\"content\"]/h1")
    private WebElement pageTitle;
    @FindBy (xpath = "//p[text()='Your shopping cart is empty!']")
    private WebElement defaultCartMessage;
    @FindBy(xpath = "//button[@data-original-title='Update']")
    private WebElement updateButton;
    @FindBy(xpath = "//button[@data-original-title='Remove']")
    private WebElement removeButton;
    @FindBy (linkText = "Use Coupon Code ")
    private WebElement expandCouponPanel;
    @FindBy(id = "input-coupon")
    private WebElement inputCoupon;
    @FindBy(id = "button-coupon")
    private WebElement couponButton;
    @FindBy (linkText = "Estimate Shipping & Taxes ")
    private WebElement expandEsShippingnTaxes;
    @FindBy (id = "input-country")
    private WebElement countryDropdown;
    @FindBy (id = "input-zone")
    private WebElement zoneDropdown;
    @FindBy (id = "input-postcode")
    private WebElement postcodeField;
    @FindBy (id = "button-quote")
    private WebElement getQuoteButton;
    @FindBy (linkText = "Use Gift Certificate ")
    private WebElement expandGift;
    @FindBy (id = "input-voucher")
    private WebElement giftCodeField;
    @FindBy(id = "button-voucher")
    private WebElement applyGiftCodeButton;
    public void goToCartPage() {
        cartIcon.click();
    }
    public void clickCartDropdown() {
        cartButton.click();
    }
    public String getDefaultCartMessage() {
        return defaultCartMessage.getText();
    }
    public String getPageTitle() {
        return pageTitle.getText();
    }
    public void clickUpdate() {
        updateButton.click();
    }
    public void clickRemove() {
        removeButton.click();
    }
    //USE COUPON CODE
    public void enterCoupon(String coupon) {
        inputCoupon.sendKeys(coupon);
    }
    public void applyCoupon() {
        couponButton.click();
    }
    public void clickCouponPanel() {
        expandCouponPanel.click();
    }
    //ESTIMATE SHIPPING AND TAXES
    public void clickShippingnTaxesPanel() {
        expandEsShippingnTaxes.click();
    }
    public void selectCountry(String countryName) {
        Select select = new Select(countryDropdown);
        select.selectByValue(countryName);
    }
    public void deselectCountry() {
        Select select = new Select(countryDropdown);
        select.deselectAll();
    }
    public void selectZone(String zoneName) {
        Select select = new Select(zoneDropdown);
        select.selectByValue(zoneName);
    }
    public void deselectZone() {
        Select select = new Select(zoneDropdown);
        select.deselectAll();
    }
    public void enterPostcode(String postcode) {
        postcodeField.sendKeys(postcode);
    }
    public void clickGetQuotes() {
        getQuoteButton.click();
    }
    //USE GIFT
    public void clickGiftPanel() {
        expandGift.click();
    }
    public void enterGiftCode(String giftCode) {
        giftCodeField.sendKeys(giftCode);
    }
    public void applyGiftCode() {
        applyGiftCodeButton.click();
    }

}
