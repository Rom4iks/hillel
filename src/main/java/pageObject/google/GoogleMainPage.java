package pageObject.google;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.AbstractPage;

public class GoogleMainPage extends AbstractPage {
    @FindBy(css = "input.gsfi")
    private WebElement searchBar;


    @FindBy(xpath = "//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']" )
    private WebElement searchButton;


    public GoogleMainPage(WebDriver webDriver) {
        super(webDriver);
    }


    public SearchResult typeText(String input ){
            searchBar.clear();
            searchBar.sendKeys(input);
            searchBar.sendKeys(Keys.ENTER);
        return new SearchResult(webDriver);
    }
}
