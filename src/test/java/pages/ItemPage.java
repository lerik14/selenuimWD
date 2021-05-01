package pages;

import core.ItemUtils;
import core.WaiterUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.ParseException;

public class ItemPage extends BasePage {

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//span[contains(@id,'priceblock')]")
    private WebElement itemPrice;

    public ItemPage() {
        super();
    }

    @Step
    public void addItemToCart() {
        addToCartBtn.click();
    }

    @Step
    public double getItemPrice() throws ParseException {
       return ItemUtils.parseItemPrice(itemPrice.getText());
    }

    public void waitPriceIsVisible() {
        WaiterUtils.waitElementToBeVisible(driver, itemPrice);
    }

}
