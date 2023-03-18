package tevolvers.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static tevolvers.utils.EndPoints.BOOKING_X;

public class GetBooking implements Task {

    private int id;
    private String accept;

    public GetBooking(int id, String accept) {
        this.id = id;
        this.accept = accept;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(BOOKING_X + id).with(requestSpecification -> requestSpecification
                        .header("Accept", accept))
        );

        SerenityRest.lastResponse().prettyPrint();
    }

    public static GetBooking getBooking(int id, String accept){
        return Tasks.instrumented(GetBooking.class, id, accept);
    }
}
