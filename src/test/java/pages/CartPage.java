package pages;

import core.ItemUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//span[@id='sc-subtotal-amount-activecart']/span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")
    private WebElement subtotalPrice;

    @FindBy(xpath = "//span[@id='sc-subtotal-label-activecart']") //Subtotal (2 items):
    private WebElement subtotalItems;

    public CartPage() {
        super();
    }

    @Step
    public double getSubtotalPrice() {
        return ItemUtils.parseItemPrice(subtotalPrice.getText());
    }

    @Step
    public String getSubtotalItems() {
        return subtotalItems.getText();
    }

}
