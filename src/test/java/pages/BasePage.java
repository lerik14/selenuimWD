package pages;

import core.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public static final String BASE_PAGE_URL = "https://www.amazon.com/";
    protected WebDriver driver = WebDriverSingleton.getWebDriver();

    public BasePage() {
        PageFactory.initElements(driver, this);
    }
}
