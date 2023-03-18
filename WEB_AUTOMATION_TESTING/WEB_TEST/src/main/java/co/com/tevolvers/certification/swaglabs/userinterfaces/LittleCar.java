package co.com.tevolvers.certification.swaglabs.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LittleCar {

    public static final Target LIST_REMOVE_PRODUCT = Target.the("button for remove products").
            located(By.xpath("//button[@class='btn btn_secondary btn_small cart_button']"));

    public static final Target REMOVE_PRODUCT = Target.the("button for remove products").
            locatedBy("(//button[@class='btn btn_secondary btn_small cart_button'])[{0}]");

    public static final Target CHECKOUT_BUTTON = Target.the("button for checkout products").
            located(By.xpath("//button[@name='checkout']"));
}
