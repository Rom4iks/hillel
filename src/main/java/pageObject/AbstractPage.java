package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public abstract class AbstractPage {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    private Actions actions;

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        actions = new Actions(webDriver);
        webDriverWait = new WebDriverWait(webDriver, 30);
        PageFactory pageFactory = new PageFactory();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        PageFactory.initElements(webDriver,this);
    }
}
