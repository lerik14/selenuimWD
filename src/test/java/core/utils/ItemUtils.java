package core.utils;

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
