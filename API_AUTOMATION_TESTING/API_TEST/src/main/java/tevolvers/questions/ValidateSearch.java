package tevolvers.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateSearch implements Question {

    @Override
    public Object answeredBy(Actor actor) {

        String response = SerenityRest.lastResponse().jsonPath().getString("additionalneeds");

        return response;
    }

    public static ValidateSearch validateSearch(){
        return new ValidateSearch();
    }
}
