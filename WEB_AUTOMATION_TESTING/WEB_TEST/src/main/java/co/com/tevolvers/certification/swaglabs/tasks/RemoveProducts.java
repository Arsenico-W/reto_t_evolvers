package co.com.tevolvers.certification.swaglabs.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static co.com.tevolvers.certification.swaglabs.userinterfaces.LittleCar.*;
import static co.com.tevolvers.certification.swaglabs.userinterfaces.MainPage.*;

public class RemoveProducts implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<String> products = Text.of(LIST_REMOVE_PRODUCT).viewedBy(actor).asList();

        int random = (int) (Math.random() * (products.size() - 1)) + 1;

        actor.attemptsTo(
                WaitUntil.the(REMOVE_PRODUCT.of(String.valueOf(random)),
                        WebElementStateMatchers.isVisible()).forNoMoreThan(5).seconds(),
                Click.on(REMOVE_PRODUCT.of(String.valueOf(random))),
                Click.on(CHECKOUT_BUTTON)
        );

    }

    public static RemoveProducts removeProducts(){
        return Tasks.instrumented(RemoveProducts.class);
    }
}
