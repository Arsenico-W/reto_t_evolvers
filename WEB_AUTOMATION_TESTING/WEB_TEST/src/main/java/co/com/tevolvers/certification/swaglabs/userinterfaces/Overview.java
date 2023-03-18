package co.com.tevolvers.certification.swaglabs.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Overview {

    public static final Target PRICES_PRODUCTS = Target.the("price of one product").
            locatedBy("(//div[@class='inventory_item_price'])[{0}]");

    public static final Target TOTAL_ITEMS = Target.the("prices of total items").
            located(By.xpath("//div[@class='summary_subtotal_label']"));

    public static final Target TAX = Target.the("price of tax").
            located(By.xpath("//div[@class='summary_tax_label']"));

    public static final Target TOTAL_PRICE = Target.the("price for total items plus tax").
            located(By.xpath("//div[@class='summary_info_label summary_total_label']"));

    public static final Target BUTTON_FINISH = Target.the("button for finish the purchase").
            located(By.xpath("//button[@class='btn btn_action btn_medium cart_button']"));
}
