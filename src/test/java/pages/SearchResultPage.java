package pages;

import core.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    private List<WebElement> listOfElements;

    @FindBy(xpath = "//*[@id='low-price']")
    private WebElement minPriceInput;

    @FindBy(xpath = "//form[@method='get']//input[@type='submit']")
    private WebElement acceptPriceRangeBtn;

    @FindBy(xpath = "//span[starts-with(@cel_widget_id, 'MAIN-SEARCH_RESULTS')]//span[@class='a-price-whole']")
    private List<WebElement> listOfElementsPrices;

    public SearchResultPage() {
        super();
    }

    public List<String> getTitles() {
        return WebDriverUtils.getTextForElementsList(listOfElements);
    }

    public Boolean isElemSponsored(String title) {
        String locatorForSearch = String.format("//span[starts-with(@cel_widget_id, 'MAIN-SEARCH_RESULTS') and " +
                ".//span[contains(text(),'%s')]]//*[text()='Sponsored']",title);
        return WebDriverUtils.isElementExist(driver, locatorForSearch);
    }

    public void setMinPrice(int minPrice) {
        minPriceInput.sendKeys(String.valueOf(minPrice));
        acceptPriceRangeBtn.click();
    }

    public int getElemPrice(int index) throws ParseException {
        NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
        return format.parse(listOfElementsPrices.get(index).getText()).intValue();
    }

}
