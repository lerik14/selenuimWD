package core.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaiterUtils {

    private static final int TIMEOUT = 30;

    public static void waitElementToBeVisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForPageLoad(WebDriver driver) {
        Wait<WebDriver> wait = new WebDriverWait(driver, TIMEOUT);
        wait.until((ExpectedCondition<Boolean>) wdriver -> ((JavascriptExecutor) driver).executeScript(
                "return document.readyState"
        ).equals("complete"));
    }
}
