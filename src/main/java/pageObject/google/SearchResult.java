package pageObject.google;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pageObject.AbstractPage;

import java.util.ArrayList;
import java.util.List;

public class SearchResult extends AbstractPage {

    @FindBys(@FindBy(css = "td:not([aria-level])"))
    private List<WebElement> pagesCount;

    @FindBys(@FindBy(css = "span.st"))
    private List<WebElement> descriptionText;


    public SearchResult(WebDriver webDriver) {
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

    public boolean findFirmName(String firmName) throws Exception {
        List<String> descriptions = getTextFromDescription();
        int i = 1;
        boolean flag = false;
        for (String description : descriptions
        ) {
            if (description.contains(firmName)) {
                System.out.println("We found it");
                takeSnapShot(webDriver, "C:\\Users\\Roman_Ilchenko1\\Desktop\\ScreenShots\\test.png");
                flag = true;

                break;
            }
            else {
                 changePage(i);
                        i++;
            }
        }
        return flag;
    }

    private String changePage(int index) {
       String numberPage= pagesCount.get(index).getText();
        pagesCount.get(index).click();
        return numberPage;
    }
}
