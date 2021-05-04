package test.selenium_tests;

import core.utils.AllureUtils;
import core.WebDriverSingleton;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class SeleniumTestsBase {

    protected WebDriver driver;

    @Rule
    public TestRule watchman = new TestWatcher() {

        @Override
        protected void failed(Throwable e, Description description) {
            AllureUtils.makeScreenshot();
        }

        @Override
        protected void starting(Description description) {
            driver = WebDriverSingleton.getWebDriver();
            driver.get(BasePage.BASE_PAGE_URL);
        }

        @Override
        protected void finished(Description description) {
            WebDriverSingleton.shutDownWebDriver();
        }
    };
}
