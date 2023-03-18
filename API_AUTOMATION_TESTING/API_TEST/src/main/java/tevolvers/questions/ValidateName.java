package tevolvers.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateName implements Question {

    private String firstname;
    private String lastname;

    public ValidateName(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public Object answeredBy(Actor actor) {
        boolean response = false;

        if (SerenityRest.lastResponse().jsonPath().getString("booking.firstname").equalsIgnoreCase(firstname)
        && SerenityRest.lastResponse().jsonPath().getString("booking.lastname").equalsIgnoreCase(lastname)){
            response = true;
        }

        return response;
    }

    public static ValidateName validateName(String firstname, String lastname){
        return new ValidateName(firstname, lastname);
    }
}
