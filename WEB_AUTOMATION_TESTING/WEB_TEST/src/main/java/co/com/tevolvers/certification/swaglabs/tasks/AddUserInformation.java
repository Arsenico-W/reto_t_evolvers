package co.com.tevolvers.certification.swaglabs.tasks;

import co.com.tevolvers.certification.swaglabs.models.UserInformation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static co.com.tevolvers.certification.swaglabs.userinterfaces.UserInformation.*;

public class AddUserInformation implements Task {

    List<UserInformation> info;

    public AddUserInformation(List<UserInformation> info) {
        this.info = info;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CHECKOUT_TITLE, WebElementStateMatchers.isVisible()).
                        forNoMoreThan(5).seconds(),
                Enter.theValue(info.get(0).getFirstname()).into(FIRSTNAME),
                Enter.theValue(info.get(0).getLastname()).into(LASTNAME),
                Enter.theValue(info.get(0).getZipCode()).into(ZIP_CODE),
                Click.on(CONTINUE_BUTTON),
                WaitUntil.the(CHECKOUT_TITLE, WebElementStateMatchers.isVisible()).
                        forNoMoreThan(5).seconds()
        );

    }

    public static AddUserInformation addUserInformation(List<UserInformation> info){
        return Tasks.instrumented(AddUserInformation.class, info);
    }
}
