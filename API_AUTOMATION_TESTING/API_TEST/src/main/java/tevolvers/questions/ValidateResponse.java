package tevolvers.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateResponse implements Question {

    @Override
    public Object answeredBy(Actor actor) {

        String response = SerenityRest.lastResponse().asString();

        return response;
    }

    public static ValidateResponse validateResponse(){
        return new ValidateResponse();
    }
}
