package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {

    private static WebDriver INSTANCE = null;

    private WebDriverSingleton() {
    }

    public static WebDriver getWebDriver() {
        if (INSTANCE == null) {
            WebDriverManager.chromedriver().setup();
            INSTANCE = new ChromeDriver();
        }
        return INSTANCE;
    }

    public static void shutDownWebDriver() {
        if (INSTANCE != null) {
            INSTANCE.quit();
            INSTANCE = null;
        }
    }
}
