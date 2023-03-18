package tevolvers.stepdefinitions;


import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;
import tevolvers.models.Booking;
import tevolvers.models.Token;
import tevolvers.questions.*;
import tevolvers.tasks.*;

import java.util.List;

import static tevolvers.utils.EndPoints.BASE_URL;

public class bookingStepDefinitions {

    @Before
    public void start() {
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(BASE_URL)));
        OnStage.theActorCalled("user");
        SerenityRest.useRelaxedHTTPSValidation();
    }

    @When("^the user enter the information$")
    public void theUserEnterTheInformation(List<Booking> info) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CreateBooking.createBooking(info)
        );
    }

    @Then("^the user see the status code (\\d+)$")
    public void theUserSeeTheStatusCode(int code) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(StatusCode.statusCode(), Matchers.equalTo(code))
        );
    }

    @Then("^the user enter the information (.*) and (.*)$")
    public void theUserEnterTheInformation(String firstname, String lastname) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(ValidateName.validateName(firstname, lastname),
                        Matchers.equalTo(true))
        );
    }

    @Then("^the user see the response check (.*)$")
    public void theUserSeeTheResponseResponseCheck(String check) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(ValidateCheck.validateCheck(check),
                        Matchers.equalTo(true))
        );
    }


    @When("^the user search by (.*) and (.*)$")
    public void theUserSearchById(int id, String accept) {
        OnStage.theActorInTheSpotlight().attemptsTo(
            GetBooking.getBooking(id, accept)
        );
    }


    @Then("^the user see the information (.*) in response$")
    public void theUserSeeTheInformationFirstnameAndLastnameInResponse(
            String additionalNeeds) {

        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(ValidateSearch.validateSearch(),
                        Matchers.equalTo(additionalNeeds))
        );
    }

    @Then("^the user see the response (.*) for search$")
    public void theUserSeeTheResponseResponseForSearch(String response) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(ValidateResponse.validateResponse(),
                        Matchers.equalTo(response))
        );
    }

    @And("^the user update a booking with (.*)$")
    public void theUserUpdateABookingWithId(int id, List<Booking> info) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                UpdateBooking.updateBooking(id, info)
        );
    }

    @When("^the user create a token$")
    public void theUserCreateAToken(List<Token> info) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CreateToken.createToken(info)
        );
    }

    @And("^the user enters the information (.*) and (.*) to update$")
    public void theUserEntersTheInformationFirstNameAndLastNameToUpdate(
            String firstname, String lastname) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(ValidateNameUpdate.validateNameUpdate(firstname, lastname),
                        Matchers.equalTo(true))
        );
    }
}
