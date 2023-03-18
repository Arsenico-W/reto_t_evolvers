package co.com.tevolvers.certification.swaglabs.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.MoveMouseToBy;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.AbstractCollection;
import java.util.Random;

import static co.com.tevolvers.certification.swaglabs.userinterfaces.MainPage.*;

public class AddProducts implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        int highest = 0;

        while(ADD_LITTLE_CAR.of(String.valueOf(highest + 1)).resolveFor(actor).isVisible()){
            highest++;
        }

        int random = (int) (Math.random() * ((highest) - 2)) + 2;

        actor.attemptsTo(
                Click.on(ADD_LITTLE_CAR.of(String.valueOf(highest))),
                Click.on(ADD_LITTLE_CAR.of(String.valueOf(random))),
                Click.on(ADD_LITTLE_CAR.of("1")),
                Scroll.to(APP_LOGO),
                Click.on(LITTLE_CAR)
        );

    }

    public static AddProducts addProducts(){
        return Tasks.instrumented(AddProducts.class);
    }
}
