package test;

import core.WebDriverSingleton;
import org.junit.*;
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

    @Before
    public void start() {
        driver = WebDriverSingleton.getWebDriver();
        driver.get(BasePage.BASE_PAGE_URL);
    }

    @Test
    public void first10TitlesContainSearchCriteriaTest() {
        header.searchFor("iphone");
        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(String.format("Title %s should contain iphone", searchResultPage.getTitles().get(i))
                    ,searchResultPage.getTitles().get(i).toLowerCase(Locale.ROOT).contains("iphone"));
        }
    }

    @Test
    public void first2TitlesAreSponsored() {
        header.searchFor("iphone");
        for (int i = 0; i < 2; i++) {
            Assert.assertTrue(String.format("Item %s should be sponsored", searchResultPage.getTitles().get(i))
                    , searchResultPage.isElemSponsored(searchResultPage.getTitles().get(i)));
            System.out.println(searchResultPage.getTitles().get(i));
        }
    }

    @Test
    public void checkMinPriceRangeForFirst1Items() throws ParseException {
        int minPrice = 400;
        header.searchFor("iphone");
        searchResultPage.setMinPrice(minPrice);
        for (int i = 0; i < 5; i++) {
            System.out.println(searchResultPage.getElemPrice(i));
            Assert.assertTrue(searchResultPage.getElemPrice(i) >= minPrice);

        }
    }

    @After
    public void close() {
        WebDriverSingleton.shutDownWebDriver();
    }

}
