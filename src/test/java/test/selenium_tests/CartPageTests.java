package test.selenium_tests;

import core.utils.WaiterUtils;
import org.junit.Test;
import pages.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartPageTests extends SeleniumTestsBase {

    private SearchResultPage searchResultPage = new SearchResultPage();
    private HeaderBlock header = new HeaderBlock();
    private ItemPage itemPage = new ItemPage();
    private CartPage cartPage = new CartPage();

    @Test
    public void checkSubtotalValuesInCart() throws InterruptedException {
        List<Double> listOfPrices = new ArrayList<>();
        List<String> listOfSearchItems = Arrays.asList("Sweese Porcelain Tea Mug with Infuser and Lid"
                , "Choary Eco-friendly Unbreakable Reusable Drinking Cup"
                , "Mora Ceramic Dinner Plates Set of 6");

        for (String listOfSearchItem : listOfSearchItems) {
            header.searchFor(listOfSearchItem);
            WaiterUtils.waitForPageLoad(driver);
            searchResultPage.clickOnItemInGridView(0);
            itemPage.waitPriceIsVisible();
            listOfPrices.add(itemPage.getItemPrice());
            itemPage.addItemToCart();
            Thread.sleep(2000); // Hardcode timeout because of
            driver.get(BasePage.BASE_PAGE_URL);
        }

        double expectedSubtotalPrice = listOfPrices.stream().reduce(0.0, Double::sum);
        header.goToCart();
        WaiterUtils.waitForPageLoad(driver);

        assertEquals(String.format("Subtotal price on page should be %s but it is %s",expectedSubtotalPrice, cartPage.getSubtotalPrice())
                ,expectedSubtotalPrice, cartPage.getSubtotalPrice(), 0.01);
        assertTrue(String.format("Subtotal number of items on page should be %s but it is %s",listOfSearchItems.size(), cartPage.getSubtotalItems())
                ,cartPage.getSubtotalItems().contains(String.valueOf(listOfSearchItems.size())));
    }
}
