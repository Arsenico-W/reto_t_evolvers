package co.com.tevolvers.certification.swaglabs.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.tevolvers.certification.swaglabs.userinterfaces.MainPage.LITTLE_CAR;

public class ValidateButtonLittleCar implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return LITTLE_CAR.resolveFor(actor).isEnabled();
    }

    public static ValidateButtonLittleCar validateButtonLittleCar(){
        return new ValidateButtonLittleCar();
    }
}
