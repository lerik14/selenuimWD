package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaiterUtils {

    public static void waitElementToBeVisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForPageLoad(WebDriver driver) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wdriver) {
                return ((JavascriptExecutor) driver).executeScript(
                        "return document.readyState"
                ).equals("complete");
            }
        });
    }

    public static void waitOneOfTwoElementsPresence(WebDriver driver, WebElement element1, WebElement element2) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(element1),
                ExpectedConditions.visibilityOf(element2)));
    }
}
