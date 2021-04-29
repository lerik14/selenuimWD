package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderBlock extends BasePage{

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchInput;

    public HeaderBlock() {
        super();
    }

    public void searchFor(String searchCriteria) {
        searchInput.sendKeys(searchCriteria);
        searchButton.click();
    }

}
