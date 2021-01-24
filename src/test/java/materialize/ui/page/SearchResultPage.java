package materialize.ui.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import lombok.RequiredArgsConstructor;
import materialize.common.BrowserComponent;
import materialize.ui.page.locator.SearchResultLocator;

@RequiredArgsConstructor
public class SearchResultPage {

    private final BrowserComponent browserComponent;

    public void isLoaded() {
        browserComponent.waitFor(
                ExpectedConditions.presenceOfElementLocated(SearchResultLocator.SEARCH_NAV_MENU.getLocator()), 10000L);
    }

    public void clickUserSearchFilter() {
        WebElement element = browserComponent.getElement(SearchResultLocator.SEARCH_NAV_USER_BUTTON.getLocator());
        element.click();
        browserComponent.waitFor(ExpectedConditions.visibilityOfElementLocated(SearchResultLocator.SEARCH_RESULTS.getLocator()), 10000L);
    }

	public List<WebElement> getSearchUserResults() {
        browserComponent.waitFor(ExpectedConditions.visibilityOfElementLocated(SearchResultLocator.SEARCH_USER_RESULTS.getLocator()), 10000L);
		return browserComponent.getElements(SearchResultLocator.USER_RESULTS_LIST.getLocator());
	}

}
