package co.com.tevolvers.certification.swaglabs.stepdefinitions;


import co.com.tevolvers.certification.swaglabs.models.UserInformation;
import co.com.tevolvers.certification.swaglabs.questions.*;
import co.com.tevolvers.certification.swaglabs.tasks.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class PurchaseStepDefinitions {

    @Managed(driver = "chrome")
    static WebDriver driver;

    @Before
    public void start(){
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(driver)));
        OnStage.theActorCalled("batman");
    }

    @Given("the user enter on the page")
    public void theUserEnterOnThePage() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://www.saucedemo.com"));
    }
    @When("the user enter the (.*) and (.*)")
    public void theUserEnterTheStandardUserAndSecretSauce(String username, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.login(username, password)
        );
    }
    @When("the user filter the page for low prices (.*)")
    public void theUserFilterThePageForLowPrices(String option) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FilterLowest.filterLowest(option)
        );
    }
    @When("the user add products to little car")
    public void theUserAddProductsToLittleCar() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddProducts.addProducts()
        );
    }
    @When("the user remove a product of little car")
    public void theUserRemoveAProductOfLittleCar() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RemoveProducts.removeProducts()
        );
    }
    @When("the user enters the information for the purchase")
    public void theUserEntersTheInformationForThePurchase(List<UserInformation> info) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddUserInformation.addUserInformation(info)
        );
    }
    @Then("the user check total items")
    public void theUserCheckTotalItems() {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(ValidateTotalItemsPage.validateTotalItemsPage(),
                        Matchers.is(true))
        );
    }
    @Then("the user check total price")
    public void theUserCheckTotalPrice() {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        ValidateTotalPricePage.validateTotalPricePage(), Matchers.is(true))
        );
    }
    @Then("the user see a message of correct purchase (.*)")
    public void theUserSeeAMessageOfCorrectPurchase(String message) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        ValidateMessagePage.validateMessagePage(),
                        Matchers.equalTo(message))
        );
    }

    @Then("^the user see products in the page$")
    public void theUserSeeProductsInThePage() {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        ValidateProductsExisting.validateProductsExisting(),
                        Matchers.is(true))
        );
    }

    @Then("^the user can to use the button of little car$")
    public void theUserSeeTheButtonOfLittleCar() {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        ValidateButtonLittleCar.validateButtonLittleCar(),
                        Matchers.is(true))
        );
    }

    @When("^the user go to little car$")
    public void theUserGoToLittleCar() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            GoToLittleCar.goToLittleCar()
        );
    }

    @Then("^the user can to user the button of CheckOut$")
    public void theUserCanToUserTheButtonOfCheckOut() {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        ValidateButtonCheckOut.validateButtonCheckOut(),
                        Matchers.is(true))
        );
    }
}
