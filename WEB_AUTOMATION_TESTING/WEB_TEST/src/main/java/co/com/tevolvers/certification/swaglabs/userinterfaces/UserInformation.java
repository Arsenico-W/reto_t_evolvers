package co.com.tevolvers.certification.swaglabs.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UserInformation {

    public static final Target FIRSTNAME = Target.the("user firstname").
            located(By.xpath("//input[@id='first-name']"));

    public static final Target LASTNAME = Target.the("user lastname").
            located(By.xpath("//input[@id='last-name']"));

    public static final Target ZIP_CODE = Target.the("user zip code").
            located(By.xpath("//input[@id='postal-code']"));

    public static final Target CONTINUE_BUTTON = Target.the("button for continue").
            located(By.xpath("//input[@id='continue']"));

    public static final Target  CHECKOUT_TITLE = Target.the("title of checkout")
            .located(By.xpath("//span[@class='title']"));
}
