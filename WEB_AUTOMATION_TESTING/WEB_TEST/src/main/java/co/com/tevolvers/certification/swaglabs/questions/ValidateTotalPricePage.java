package co.com.tevolvers.certification.swaglabs.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.tevolvers.certification.swaglabs.userinterfaces.Overview.*;

public class ValidateTotalPricePage implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        boolean response = false;

        float totalItemsPage = Float.parseFloat(TOTAL_ITEMS.resolveFor(actor)
                .getText().replace("Item total: $",""));
        totalItemsPage = Float.parseFloat(String.format("%.2f", totalItemsPage));

        float tax = Float.parseFloat(TAX.resolveFor(actor).
                getText().replace("Tax: $",""));
        tax = Float.parseFloat(String.format("%.2f", tax));

        float totalPricePage = Float.parseFloat(TOTAL_PRICE.resolveFor(actor).
                getText().replace("Total: $",""));
        totalPricePage = Float.parseFloat(String.format("%.2f", totalPricePage));

        float totalPrice = totalItemsPage + tax;
        totalPrice = Float.parseFloat(String.format("%.2f", totalPrice));

        if (totalPrice == totalPricePage){
            response = true;
        }

        return response;
    }

    public static ValidateTotalPricePage validateTotalPricePage(){
        return new ValidateTotalPricePage();
    }
}
