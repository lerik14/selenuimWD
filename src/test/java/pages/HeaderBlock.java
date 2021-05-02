package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderBlock extends BasePage{

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchInput;

    @FindBy(xpath = "//a[@href='/gp/cart/view.html?ref_=nav_cart']")
    private WebElement cartButton;

    public HeaderBlock() {
        super();
    }

    @Step
    public void searchFor(String searchCriteria) {
        searchInput.clear();
        searchInput.sendKeys(searchCriteria);
        searchButton.click();
    }

    @Step
    public void goToCart() {
        cartButton.click();
    }
}
