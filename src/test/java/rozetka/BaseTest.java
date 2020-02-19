package rozetka;

import lombok.Getter;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.AbstractPage;

@Getter
public abstract class BaseTest {

    protected WebDriver webDriver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @After
    public void shutDownDriver() {
        webDriver.close();
        webDriver.quit();
    }
}
