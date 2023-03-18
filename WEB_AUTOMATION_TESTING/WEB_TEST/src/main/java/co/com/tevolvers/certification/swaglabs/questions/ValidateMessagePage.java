package co.com.tevolvers.certification.swaglabs.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.tevolvers.certification.swaglabs.userinterfaces.Overview.BUTTON_FINISH;
import static co.com.tevolvers.certification.swaglabs.userinterfaces.UserInformation.CHECKOUT_TITLE;
import static co.com.tevolvers.certification.swaglabs.userinterfaces.MessageSuccessful.MESSAGE;

public class ValidateMessagePage implements Question {

    @Override
    public Object answeredBy(Actor actor) {
        actor.attemptsTo(
                Scroll.to(BUTTON_FINISH),
                Click.on(BUTTON_FINISH),
                WaitUntil.the(CHECKOUT_TITLE, WebElementStateMatchers.isVisible()).
                        forNoMoreThan(5).seconds()
        );

        String message = MESSAGE.resolveFor(actor).getText();

        return message;
    }

    public static ValidateMessagePage validateMessagePage(){
        return new ValidateMessagePage();
    }
}
