package tevolvers.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import tevolvers.models.Token;

import java.util.List;

import static tevolvers.utils.EndPoints.TOKEN;

public class CreateToken implements Task {

    private List<Token> info;

    public CreateToken(List<Token> info) {
        this.info = info;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(TOKEN).with(requestSpecification -> requestSpecification
                        .header("Content-Type", info.get(0).getContentType())
                        .contentType(ContentType.JSON)
                        .body(info.get(0).toString())
                        .log().all())
        );
        actor.remember("token", SerenityRest.lastResponse().jsonPath().getString("token"));
    }

    public static CreateToken createToken(List<Token> info){
        return Tasks.instrumented(CreateToken.class, info);
    }
}
