package materialize.ui.page.locator;

import org.openqa.selenium.By;

import lombok.Getter;

@Getter
public enum LandingPageLocator {
    APPLICATION_MAIN(By.xpath("//div[contains(@class, 'application-main')]"));

    private By locator;
    LandingPageLocator(By locator) {
        this.locator = locator;
    }
}
