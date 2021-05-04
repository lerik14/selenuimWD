package test.appium_tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.CalculatorPage;

import java.net.MalformedURLException;
import java.net.URL;

@RunWith(JUnitParamsRunner.class)
public class AppiumTest {

    protected AndroidDriver<MobileElement> driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "pixel 4");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(CapabilityType.VERSION, "11.0");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }

    @After
    public void shutDown() {
        driver.quit();
    }

    @Test
    @Parameters(method = "sumTestData")
    public void sumTest(int expectedResult, String ... numbers) throws InterruptedException {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        Thread.sleep(3000);
        calculatorPage.performSum(numbers);
        Assert.assertEquals(expectedResult, calculatorPage.getResult());
    }

    private Object[] sumTestData() {
        return new Object[]{
                new Object[]{150, "123", "5", "22"},
                new Object[]{-5, "-5", "0"},
                new Object[]{75, "15", "60"}
        };
    }
}
