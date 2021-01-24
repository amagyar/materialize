package materialize.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import materialize.common.BrowserComponent;
import materialize.common.ContextKey;
import materialize.common.ScenarioContext;
import materialize.ui.page.HeaderPage;
import materialize.ui.page.LandingPage;

@RequiredArgsConstructor
public class LandingPageSteps {

    private final ScenarioContext scenarioContext;
    private final BrowserComponent browserComponent;
    private final HeaderPage headerPage;
    private final LandingPage landingPage;

    @Given("browser navigates to landing page")
    public void navigateToLandingPage() {
        browserComponent.navigate("https://github.com");
    }

    @Then("the landing page is loaded")
    public void waitLoad() throws InterruptedException {
        headerPage.isLoaded();
        landingPage.isLoaded();
    }

    @When("search for login {string} on landing page is executed")
    public void searchFor(String login) {
        scenarioContext.put(ContextKey.USER_LOGIN, login);
        headerPage.search(login);
    }
}
