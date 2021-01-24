package materialize.ui;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.hamcrest.MatcherAssert;

import io.cucumber.java.en.Given;
import lombok.RequiredArgsConstructor;
import materialize.lifecycle.BrowserInstanceLifecycle;

@RequiredArgsConstructor
public class BrowserSteps {

    private final BrowserInstanceLifecycle browserInstanceLifecycle;;

    @Given("browser is started")
    public void browserIsStarted() {
        MatcherAssert.assertThat("Browser should have been started", browserInstanceLifecycle.getWebDriver(), is(notNullValue()));
    }
}
