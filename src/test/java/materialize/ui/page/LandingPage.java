package materialize.ui.page;

import org.openqa.selenium.support.ui.ExpectedConditions;

import lombok.RequiredArgsConstructor;
import materialize.common.BrowserComponent;
import materialize.ui.page.locator.LandingPageLocator;

@RequiredArgsConstructor
public class LandingPage {

    private final BrowserComponent browserComponent;

    public void isLoaded() {
        browserComponent.waitFor(ExpectedConditions.presenceOfElementLocated(LandingPageLocator.APPLICATION_MAIN.getLocator()), 10000L);
    }
}
