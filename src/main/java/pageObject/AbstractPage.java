package pageObject;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public abstract class AbstractPage {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected Actions actions;
    protected TakesScreenshot ts;

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        actions = new Actions(webDriver);
        webDriverWait = new WebDriverWait(webDriver, 10);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(webDriver,this);
        ts = (TakesScreenshot)webDriver;
    }
}
