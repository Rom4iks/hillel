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

    public boolean findFirmName(String firmName) throws Exception {
        boolean flag = true;
        String pageNumber = "";
        while (flag) {
            for (WebElement description : descriptionText
            ) {
                if (description.getText().contains(firmName)) {
                    System.out.println("We found it");
                    takeSnapShot(webDriver, "C:\\Users\\Roman_Ilchenko1\\Desktop\\ScreenShots\\test.png");
                    flag = false;
                    System.out.println(pageNumber);
                    break;
                } else {
                    pageNumber = currentPageNumber.getText();
                }
            }
            System.out.println("No info on " + pageNumber + " page!!!");
            System.out.println("Moving from " + pageNumber + " Next Page ");
            nextPageButton.click();
        }
        return flag;
    }

    private String changePage(int index) {
        String numberPage = pagesCount.get(index).getText();
        pagesCount.get(index).click();
        return numberPage;
    }


}
