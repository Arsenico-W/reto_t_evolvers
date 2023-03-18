package co.com.tevolvers.certification.swaglabs.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.tevolvers.certification.swaglabs.userinterfaces.MainPage.LITTLE_CAR;
import static co.com.tevolvers.certification.swaglabs.userinterfaces.UserInformation.CHECKOUT_TITLE;

public class GoToLittleCar implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LITTLE_CAR),
                WaitUntil.the(CHECKOUT_TITLE,
                        WebElementStateMatchers.isVisible()).forNoMoreThan(5).seconds()
        );
    }

    public static GoToLittleCar goToLittleCar(){
        return Tasks.instrumented(GoToLittleCar.class);
    }
}


