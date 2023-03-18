package tevolvers.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;
import tevolvers.models.Booking;

import java.util.List;

import static tevolvers.utils.EndPoints.BOOKING_X;

public class UpdateBooking implements Task {

    private int id;
    private List<Booking> info;

    public UpdateBooking(int id, List<Booking> info) {
        this.id = id;
        this.info = info;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String token = actor.recall("token");
        actor.attemptsTo(
                Put.to(BOOKING_X + id).with(requestSpecification -> requestSpecification
                        .header("Content-Type", info.get(0).getContentType())
                        .header("Accept", info.get(0).getAccept())
                        .header("Cookie", "token=" + token)
                        .contentType(ContentType.JSON)
                        .body(info.get(0).toString())
                        .log().all())
        );

        SerenityRest.lastResponse().prettyPrint();
    }

    public static UpdateBooking updateBooking(int id, List<Booking> info){
        return Tasks.instrumented(UpdateBooking.class, id, info);
    }
}
