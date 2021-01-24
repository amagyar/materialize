package materialize.ui.page.locator;

import org.openqa.selenium.By;

import lombok.Getter;

@Getter
public enum HeaderLocator {
    SEARCH_INPUT(By.xpath("//input[@name = 'q']"));

    private By locator;
    HeaderLocator(By locator) {
        this.locator = locator;
    }
}
