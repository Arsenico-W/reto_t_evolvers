package tevolvers.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateNameUpdate implements Question {

    private String firstname;
    private String lastname;

    public ValidateNameUpdate(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public Object answeredBy(Actor actor) {
        boolean response = false;

        if (SerenityRest.lastResponse().jsonPath().getString("firstname").equalsIgnoreCase(firstname)
                && SerenityRest.lastResponse().jsonPath().getString("lastname").equalsIgnoreCase(lastname)){
            response = true;
        }

        return response;
    }

    public static ValidateNameUpdate validateNameUpdate(String firstname, String lastname){
        return new ValidateNameUpdate(firstname, lastname);
    }
}
