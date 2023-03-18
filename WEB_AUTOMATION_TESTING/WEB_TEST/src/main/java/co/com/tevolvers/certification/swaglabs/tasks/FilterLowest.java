package co.com.tevolvers.certification.swaglabs.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.tevolvers.certification.swaglabs.userinterfaces.MainPage.*;

public class FilterLowest implements Task {

    private String option;

    public FilterLowest(String option) {
        this.option = option;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(FILTER_PRODUCTS, WebElementStateMatchers.isVisible()).
                        forNoMoreThan(5).seconds(),
                Click.on(FILTER_PRODUCTS),
                Click.on(LOWEST_PRICE.of(option))
        );

    }

    public static FilterLowest filterLowest(String option){
        return Tasks.instrumented(FilterLowest.class, option);
    }
}
