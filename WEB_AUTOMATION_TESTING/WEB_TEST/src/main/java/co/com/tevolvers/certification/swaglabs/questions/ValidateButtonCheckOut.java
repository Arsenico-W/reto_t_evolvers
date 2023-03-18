package co.com.tevolvers.certification.swaglabs.questions;

import cucumber.api.java.bs.A;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.tevolvers.certification.swaglabs.userinterfaces.LittleCar.CHECKOUT_BUTTON;

public class ValidateButtonCheckOut implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return CHECKOUT_BUTTON.resolveFor(actor).isEnabled();
    }

    public static ValidateButtonCheckOut validateButtonCheckOut(){
        return new ValidateButtonCheckOut();
    }
}
