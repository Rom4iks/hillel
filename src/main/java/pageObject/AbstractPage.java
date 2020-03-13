package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.unitils.thirdparty.org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;
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
        webDriverWait = new WebDriverWait(webDriver, 20);
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        PageFactory.initElements(webDriver, this);
        ts = (TakesScreenshot) webDriver;
        js = (JavascriptExecutor) webDriver;
    }


    private static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);

    }

    public boolean findInputViaPages(WebElement nextPageButton, List<WebElement> descriptionText, String firmName, boolean searchOnAllPages) throws Exception {
        boolean flag = true;
        int pageNumber = 1;
        while (flag) {
            for (WebElement description : descriptionText
            ) {
                if (description.getText().contains(firmName)) {
                    actions.moveToElement(description).perform();
                    takeSnapShot(webDriver, "C:\\Users\\Roman_Ilchenko1\\Desktop\\ScreenShots\\" + firmName + "_" + pageNumber + ".png");
                    System.out.println("Input found on " + pageNumber + " page.");
                    flag = false;
                    break;
                }
            }
            if (flag & searchOnAllPages) {
                pageNumber++;
                try {
                    nextPageButton.click();
                }catch (Exception e){
                    break;
                }
            }
            else
                break;

        }
        return flag;
    }
}
