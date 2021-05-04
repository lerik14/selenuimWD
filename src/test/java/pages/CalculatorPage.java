package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CalculatorPage {

    protected AndroidDriver<MobileElement> driver;
    private String digitId = "com.google.android.calculator:id/digit_";

    @FindBy(id = "com.google.android.calculator:id/op_add")
    private MobileElement sumBtn;

    @FindBy(id = "com.google.android.calculator:id/op_sub")
    private MobileElement subtractionBtn;

    @FindBy(id = "com.google.android.calculator:id/eq")
    private MobileElement equalBtn;

    @FindBy(id = "com.google.android.calculator:id/result_final")
    private MobileElement result;

    public CalculatorPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
    }

    public void performSum(String ... numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            enterNumber(numbers[i]);
            sumBtn.click();
        }
        enterNumber(numbers[numbers.length - 1]);
        equalBtn.click();
    }

    public int getResult() {
        // In calculator negative number uses minus sign and because of this parseInt throws exception.
        // That is why here is minus sign is replaced on hyphen
        String text = result.getText().replace('−','-');
        return Integer.parseInt(text);
    }

    public void enterNumber(String number) {
        char[] digits = number.toCharArray();
        for (char digit : digits) {
            if (digit == '-') {
                subtractionBtn.click();
            } else {
                driver.findElementById(digitId + digit).click();
            }
        }
    }
}
