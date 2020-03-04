package pageObject.rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.AbstractPage;

public class RozetkaMainPage extends AbstractPage {

    WebDriver webDriver;


    public RozetkaMainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//button[@class ='menu-toggler']")
    private WebElement catalogButton;

    @FindBy(xpath = "//a[@class = 'menu__link' and contains(text(),'Dell')]")
    private WebElement lapTopDellCategory;

    public void selectDellLaptops() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(catalogButton));
        catalogButton.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lapTopDellCategory));
        lapTopDellCategory.click();

    }

}
