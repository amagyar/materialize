package materialize.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import lombok.RequiredArgsConstructor;
import materialize.lifecycle.BrowserInstanceLifecycle;

@RequiredArgsConstructor
public class BrowserComponent {

    private final BrowserInstanceLifecycle browserInstanceLifecycle;

    protected WebDriver getWebDriver() {
        return browserInstanceLifecycle.getWebDriver();
    }

    public void navigate(String url) {
        getWebDriver().get(url);
    }

    public void waitFor(ExpectedCondition<?> expectedCondition, long timeout) {
        new WebDriverWait(getWebDriver(), timeout).until(expectedCondition);
    }

    public WebElement getElement(By locator) {
        return getWebDriver().findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        return getWebDriver().findElements(locator);
    }
}
