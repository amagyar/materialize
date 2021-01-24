package materialize.ui.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import lombok.RequiredArgsConstructor;
import materialize.common.BrowserComponent;
import materialize.ui.page.locator.HeaderLocator;

@RequiredArgsConstructor
public class HeaderPage {

    private final BrowserComponent browserComponent;

    public void isLoaded() {
        browserComponent.waitFor(ExpectedConditions.presenceOfElementLocated(HeaderLocator.SEARCH_INPUT.getLocator()),
                10000);
    }

    public void search(String text) {
        WebElement webElement = browserComponent.getElement(HeaderLocator.SEARCH_INPUT.getLocator());
        webElement.click();
        webElement.sendKeys(text);
        webElement.sendKeys(Keys.RETURN);
    }

    public void click(HeaderLocator xpathLocator) {
        WebElement webElement = browserComponent.getElement(xpathLocator.getLocator());
        webElement.click();
    }
}
