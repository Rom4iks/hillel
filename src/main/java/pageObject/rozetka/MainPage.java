package pageObject.rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.AbstractPage;

public class MainPage extends AbstractPage {

    WebDriver webDriver;


    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//button[@class ='menu-toggler']")
    private WebElement catalogButton;

    @FindBy(xpath = "//a[@class = 'menu__link' and contains(text(),'Dell')]")
    private WebElement lapTopDellCategory;
//    @FindBy(xpath = "//a[@class = 'menu__hidden-title' and contains(text(),'Ноутбуки')]/..")
//    private WebElement noteBookBlock;
//    @FindBy(xpath = ".//a[@class = 'menu__link' and contains(text(),'ell')]")
//    private WebElement dellCategoryLapTop;

    public void selectDellLaptops() {
        catalogButton.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lapTopDellCategory));
        lapTopDellCategory.click();
    }

}
