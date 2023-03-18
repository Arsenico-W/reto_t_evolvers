package co.com.tevolvers.certification.swaglabs.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src\\test\\resources\\features\\purchase.feature",
                 glue = "co.com.tevolvers.certification.swaglabs.stepdefinitions",
                 snippets = SnippetType.CAMELCASE
)
public class PurchaseRunner {
}
