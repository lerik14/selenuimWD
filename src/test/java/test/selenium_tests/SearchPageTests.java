package test.selenium_tests;

import core.AllureUtils;
import core.WebDriverSingleton;
import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.HeaderBlock;
import pages.SearchResultPage;

import java.text.ParseException;
import java.util.Locale;

public class SearchPageTests {

    private WebDriver driver;
    private SearchResultPage searchResultPage = new SearchResultPage();
    private HeaderBlock header = new HeaderBlock();

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

    @Test
    public void first10TitlesContainSearchCriteriaTest() {
        header.searchFor("iphone");
        for (int i = 0; i < 10; i++) {
            String elementTitle = searchResultPage.getTitles().get(i);
            Assert.assertTrue(String.format("Title %s should contain iphone", elementTitle)
                    ,elementTitle.toLowerCase(Locale.ROOT).contains("iphone"));
        }
    }

    @Test
    public void first2TitlesAreSponsored() {
        header.searchFor("iphone");
        for (int i = 0; i < 2; i++) {
            String elementTitle = searchResultPage.getTitles().get(i);
            Assert.assertTrue(String.format("Item %s should be sponsored", elementTitle)
                    , searchResultPage.isElemSponsored(elementTitle));
        }
    }

    @Test
    public void checkMinPriceRangeForFirst5Items() throws ParseException {
        int minPrice = 400;
        header.searchFor("iphone");
        searchResultPage.setMinPrice(minPrice);
        for (int i = 0; i < 5; i++) {
            int elementPrice = searchResultPage.getElemPrice(i);
            Assert.assertTrue(String.format("Item %s should cost more %s but it costs %s",
                    searchResultPage.getTitles().get(i), minPrice, elementPrice)
                    ,elementPrice >= minPrice);
        }
    }
}
