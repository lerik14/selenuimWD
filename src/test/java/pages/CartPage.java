package pages;

import core.utils.ItemUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//span[@id='sc-subtotal-amount-activecart']/span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")
    private WebElement subtotalPrice;

    @FindBy(xpath = "//span[@id='sc-subtotal-label-activecart']")
    private WebElement subtotalItems;

    public CartPage() {
        super();
    }

    @Step
    public double getSubtotalPrice() {
        return ItemUtils.parseItemPrice(subtotalPrice.getText());
    }

    @Step
    public String getTotalNumberOfItemsInCart() {
        return subtotalItems.getText();
    }
}
