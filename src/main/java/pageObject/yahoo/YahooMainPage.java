package pageObject.yahoo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.AbstractPage;
import pageObject.google.SearchResult;

public class YahooMainPage extends AbstractPage {
    @FindBy(css = "#header-search-input")
    private WebElement searchBar;


    @FindBy(xpath = "//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']" )
    private WebElement searchButton;


    public YahooMainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public YahooSearchResult typeText(String input ){
        searchBar.clear();
        searchBar.sendKeys(input);
        searchBar.sendKeys(Keys.ENTER);
        return new YahooSearchResult(webDriver);
    }
}
