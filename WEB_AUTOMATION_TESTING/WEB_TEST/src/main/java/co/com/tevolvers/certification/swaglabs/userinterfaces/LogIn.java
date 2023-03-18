package co.com.tevolvers.certification.swaglabs.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LogIn {

    public static final Target USERNAME  = Target.the("username input").
            located(By.xpath("//input[@id=\"user-name\"]"));

    public static final Target PASSWORD = Target.the("password input").
            located(By.xpath("//input[@id=\"password\"]"));

    public static final Target BTN_LOGIN = Target.the("button for login").
            located(By.xpath("//input[@id=\"login-button\"]"));

}
