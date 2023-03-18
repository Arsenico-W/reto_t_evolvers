package co.com.tevolvers.certification.swaglabs.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MessageSuccessful {

    public static final Target MESSAGE = Target.the("message for purchase successful").
            located(By.xpath("//h2[@class='complete-header']"));
}
