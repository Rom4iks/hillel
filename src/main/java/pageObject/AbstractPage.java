package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.unitils.thirdparty.org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;


public abstract class AbstractPage {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected Actions actions;
    protected TakesScreenshot ts;
    protected JavascriptExecutor js;

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        actions = new Actions(webDriver);
        webDriverWait = new WebDriverWait(webDriver, 10);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(webDriver,this);
        ts = (TakesScreenshot)webDriver;
        js = (JavascriptExecutor)webDriver;
    }


    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);

    }
}
