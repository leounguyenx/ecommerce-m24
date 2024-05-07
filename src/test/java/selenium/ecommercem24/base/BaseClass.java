package selenium.ecommercem24.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
    static WebDriver driver;
    static String browserName = "chrome";
    static String url = "https://tutorialsninja.com/demo/";

    public static WebDriver init() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
}
