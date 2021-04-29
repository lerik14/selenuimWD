package core;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureUtils {

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] makeScreenshot() {
        return ((TakesScreenshot) WebDriverSingleton.getWebDriver()).getScreenshotAs(OutputType.BYTES);

    }
}
