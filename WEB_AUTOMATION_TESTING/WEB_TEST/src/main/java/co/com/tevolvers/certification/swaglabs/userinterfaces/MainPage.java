package co.com.tevolvers.certification.swaglabs.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MainPage {

    public static final Target FILTER_PRODUCTS = Target.the("filter for products").
            located(By.xpath("//span[@class=\"select_container\"]"));

    public static final Target LOWEST_PRICE = Target.the("filter for lowest price").
            locatedBy("(//select[@class=\"product_sort_container\"]//option)[{0}]");

    public static final Target ADD_LITTLE_CAR = Target.the("add products to little car")
            .locatedBy("(//button[@class='btn btn_primary btn_small btn_inventory'])[{0}]");

    public static final Target LITTLE_CAR = Target.the("access to little car").
            located(By.xpath("//a[@class='shopping_cart_link']"));

    public static final Target APP_LOGO = Target.the("app logo").
            located(By.xpath("//div[@class='app_logo']"));

}
