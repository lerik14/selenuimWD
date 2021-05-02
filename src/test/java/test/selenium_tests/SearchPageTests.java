package test.selenium_tests;

import org.junit.Assert;
import org.junit.Test;
import pages.HeaderBlock;
import pages.SearchResultPage;

import java.text.ParseException;
import java.util.Locale;

public class SearchPageTests extends SeleniumTestsBase {

    private SearchResultPage searchResultPage = new SearchResultPage();
    private HeaderBlock header = new HeaderBlock();

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
    public void checkMinPriceRangeForFirst5Items() {
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
