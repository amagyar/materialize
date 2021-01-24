package materialize.lifecycle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BrowserInstanceLifecycle {
    private WebDriver driver;

    @Before("@UI")
    public void createBrowser() {
        driver = new FirefoxDriver();
    }

    @After("@UI")
    public void closeBrowser() {
        driver.close();
    }

    public WebDriver getWebDriver() {
        return driver;
    }
}
