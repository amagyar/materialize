package materialize.api;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.CoreMatchers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import materialize.api.model.User;
import materialize.common.ContextKey;
import materialize.common.ScenarioContext;

@RequiredArgsConstructor
public class SearchSteps {

    private final SearchComponent searchComponent;
    private final ScenarioContext scenarioContext;

    @Given("the login {string}")
    public void givenNickname(String nickname) {
        scenarioContext.put(ContextKey.USER_LOGIN, nickname);
    }

    @When("the login is used to search for an user")
    public void searchByNickname() {
        String nickname = scenarioContext.get(ContextKey.USER_LOGIN, String.class);
        User user = searchComponent.findUserByNickname(nickname);
        scenarioContext.put(ContextKey.USER, user);
    }

    @Then("the user should be found")
    public void userShouldBeFound() {
        User user = scenarioContext.get(ContextKey.USER, User.class);
        assertThat("User should exist", user, is(CoreMatchers.notNullValue()));
        assertThat("User should have an id", user.getId(), is(notNullValue()));
    }

    @Then("the user's login should match the expected one")
    public void userShouldMatchNickname() {
        User user = scenarioContext.get(ContextKey.USER, User.class);
        assertThat("Login should match", user.getLogin(), is(scenarioContext.get(ContextKey.USER_LOGIN)));
    }
}
