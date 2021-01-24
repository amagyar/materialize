package materialize.ui.page.locator;

import org.openqa.selenium.By;

import lombok.Getter;

@Getter
public enum SearchResultLocator {
    SEARCH_NAV_MENU(By.xpath("//nav[contains(@class, 'menu')]")),
    SEARCH_NAV_USER_BUTTON(By.xpath("//nav[contains(@class, 'menu')]//a[contains(@href, 'users')]")), 
    SEARCH_RESULTS(By.xpath("//div[contains(@class, 'codesearch-results')]")),
    SEARCH_USER_RESULTS(By.xpath("//div[@id = 'user_search_results']")),
    USER_RESULTS_LIST(By.xpath("//div[@id = 'user_search_results']/div/div"));

    private By locator;
    SearchResultLocator(By locator) {
        this.locator = locator;
    }
}
