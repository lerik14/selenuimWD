package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ItemUtils {

    public static double parseItemPrice(String price) {
        NumberFormat format = NumberFormat.getInstance(Locale.US);
        try {
            return format.parse(price.replace("$", "")).doubleValue();
        } catch (ParseException e) {
            System.out.println("Unable to parse price " + price);
            return -1;
        }
    }



}
