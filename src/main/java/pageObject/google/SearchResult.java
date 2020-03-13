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

    @FindBy(css = "a#pnnext")
    private WebElement nextPageButton;

    @FindBy(css = "td.cur")
    private WebElement currentPageNumber;

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

    public boolean findInputViaPages(String firmName, boolean searchOnAllPages) throws Exception {
        boolean flag = true;
        int pageNumber = 1;
        while (flag) {
            for (WebElement description : descriptionText
            ) {
                if (description.getText().contains(firmName)) {
                    takeSnapShot(webDriver, "C:\\Users\\Roman_Ilchenko1\\Desktop\\ScreenShots\\"+firmName+"_"+pageNumber+ ".png");
                    System.out.println("Input found on " +pageNumber + " page.");
                    flag = false;
                    break;
                }
            }
            if (flag & searchOnAllPages) {
                pageNumber++;
                nextPageButton.click();
            }
        }
        return flag;
    }

    private String changePage(int index) {
        String numberPage = pagesCount.get(index).getText();
        pagesCount.get(index).click();
        return numberPage;
    }


}
