package co.com.tevolvers.certification.swaglabs.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.tevolvers.certification.swaglabs.userinterfaces.Overview.*;

public class ValidateTotalItemsPage implements Question {

    @Override
    public Object answeredBy(Actor actor) {
        boolean response = false;
        float totalItems = 0;
        int i = 1;

        while(PRICES_PRODUCTS.of(String.valueOf(i)).resolveFor(actor).isVisible()){
            totalItems += Float.parseFloat(
                    PRICES_PRODUCTS.of(String.valueOf(i)).
                            resolveFor(actor).getText().replace("$",""));
            i++;
        }

        float totalItemsPage = Float.parseFloat(TOTAL_ITEMS.resolveFor(actor)
                .getText().replace("Item total: $",""));
        totalItemsPage = Float.parseFloat(String.format("%.2f", totalItemsPage));

        totalItems = Float.parseFloat(String.format("%.2f", totalItems));



        if (totalItems == totalItemsPage){
            response = true;
        }

        return response;
    }

    public static ValidateTotalItemsPage validateTotalItemsPage(){
        return new ValidateTotalItemsPage();
    }
}
