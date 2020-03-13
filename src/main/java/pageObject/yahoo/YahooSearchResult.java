package pageObject.yahoo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pageObject.AbstractPage;

import java.util.ArrayList;
import java.util.List;


public class YahooSearchResult extends AbstractPage {

    @FindBys(@FindBy(css = "li p"))
    private List<WebElement> descriptionText;


    @FindBy(css = "a.next")
    private WebElement nextPageButton;


    public YahooSearchResult(WebDriver webDriver) {
        super(webDriver);
    }

    public List<String> getTextFromDescription() {
        List<String> descriptions = new ArrayList<>();
        for (WebElement description : descriptionText
        ) {
            String text = description.getText();
            descriptions.add(text);
        }
        return descriptions;
    }


    public boolean findInputViaPages(String firmName, boolean searchOnAllPages) throws Exception {
        return super.findInputViaPages(nextPageButton, descriptionText, firmName, searchOnAllPages);
    }
}
