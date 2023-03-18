package tevolvers.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateCheck implements Question {

    private String check;

    public ValidateCheck(String check) {
        this.check = check;
    }

    @Override
    public Object answeredBy(Actor actor) {
        boolean response = false;

        if (SerenityRest.lastResponse().jsonPath().
                getString("booking.bookingdates.checkin").equalsIgnoreCase(check)
        || SerenityRest.lastResponse().jsonPath().
                getString("booking.bookingdates.checkout").equalsIgnoreCase(check)){
            response = true;
        }

        return response;
    }

    public static ValidateCheck validateCheck(String check){
        return new ValidateCheck(check);
    }
}
