package co.com.tevolvers.certification.swaglabs.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.tevolvers.certification.swaglabs.userinterfaces.MainPage.ADD_LITTLE_CAR;

public class ValidateProductsExisting implements Question {

    @Override
    public Object answeredBy(Actor actor) {

        return ADD_LITTLE_CAR.of("1").resolveFor(actor).isVisible();
    }

    public static ValidateProductsExisting validateProductsExisting(){
        return new ValidateProductsExisting();
    }
}
