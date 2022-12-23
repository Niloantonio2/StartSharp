package co.com.choucair.cetification.startsharp.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/startSharpE2E.feature",
        tags = "",
        glue = "co.com.choucair.cetification.startsharp.stepdefinitions",
        snippets = SnippetType.CAMELCASE)
public class StartSharpE2ERunner {
}
