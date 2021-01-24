package materialize.ui;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import materialize.common.ContextKey;
import materialize.common.ScenarioContext;
import materialize.ui.page.SearchResultPage;

@RequiredArgsConstructor
public class SearchResultPageSteps {

    private final ScenarioContext scenarioContext;
    private final SearchResultPage searchResultPage;

    @Then("the search result page is loaded")
    public void searchResultPageIsLoaded() {
        searchResultPage.isLoaded();
    }

    @When("the button Users is clicked on search result nav menu")
    public void clickUsers() {
        searchResultPage.clickUserSearchFilter();
    }

    @Then("the search result should relate to search term")
    public void assertSearch() {
        String login = scenarioContext.get(ContextKey.USER_LOGIN, String.class);
        List<WebElement> elements = searchResultPage.getSearchUserResults();
        assertThat("Should contain at least 1 entry", elements.size(), is(greaterThan(1)));
        for (WebElement element : elements) {
            assertThat("Result should contain expected term", element.getText(), containsString(login));
        }
    }
}
