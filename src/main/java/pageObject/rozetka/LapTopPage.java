package pageObject.rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pageObject.AbstractPage;

import java.io.BufferedWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LapTopPage  extends AbstractPage {
    public LapTopPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBys(@FindBy(xpath = "//div[@appfilterroot]/button[contains(text(),'дискретной')]/..//label"))
    private List<WebElement> videoCards;


    @FindBy(xpath = "//div[@appfilterroot]/button[contains(text(),'дискретной')]/..")
    private WebElement sideBlock;

    public  List<String>  addToTxtVideo() throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("C:\\my.txt"));
        List<String> textCategory = new ArrayList<>();
        for (WebElement videoCard:videoCards
             ) {
            String text= videoCard.getAttribute("for");
            System.out.println(text);
            textCategory.add(text);
            writer.write(text);
            writer.newLine();
        }
        return textCategory;
    }

}


