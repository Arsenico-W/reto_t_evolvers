package tevolvers.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import tevolvers.models.Booking;

import java.util.List;

import static tevolvers.utils.EndPoints.BOOKING_POST;

public class CreateBooking implements Task {

    private List<Booking> info;

    CreateBooking(List<Booking> info){
        this.info = info;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(BOOKING_POST).with(requestSpecification -> requestSpecification
                        .header("Content-Type", info.get(0).getContentType())
                        .header("Accept", info.get(0).getAccept())
                        .contentType(ContentType.JSON)
                        .body(info.get(0).toString())
                        .log().all())

        );

        SerenityRest.lastResponse().prettyPrint();
    }

    public static CreateBooking createBooking(List<Booking> info){
        return Tasks.instrumented(CreateBooking.class, info);
    }
}
