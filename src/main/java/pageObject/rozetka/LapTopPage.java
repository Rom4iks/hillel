package pageObject.rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pageObject.AbstractPage;
import utills.LaptopsItems;

import java.io.BufferedWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class LapTopPage extends AbstractPage {
    public LapTopPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBys(@FindBy(xpath = "//div[@appfilterroot]/button[contains(text(),'дискретной')]/..//label"))
    private List<WebElement> videoCards;

    @FindBy(xpath = "//div[@appfilterroot]/button[contains(text(),'дискретной')]/..")
    private WebElement sideBlock;

    @FindBy(xpath = "//div[@class ='goods-tile__inner']")
    private List<WebElement> laptops;



    private static final String NAME_LOCATOR = ".//a[@class ='goods-tile__heading']"; //getAtribute("title")
    private static final String PRICE_LOCATOR = ".//span[@class ='goods-tile__price-value']"; //getText()
    private static final String STATUS_LOCATOR = ".//div[contains(@class,'goods-tile__availability')]"; //getText()
    private static final String DESCRIPTION_LOCATOR = ".//p[contains(@class,'goods-tile__description')]"; //getText()


    public List<String> addToTxtVideo() throws IOException {
//        BufferedWriter writer = Files.newBufferedWriter(Paths.get("C:\\my.txt"));
        List<String> textCategory = new ArrayList<>();
        for (WebElement videoCard : videoCards
        ) {
            String text = videoCard.getAttribute("for");
            System.out.println(text);
            textCategory.add(text);
//            writer.write(text);
//            writer.newLine();
        }
        return textCategory;
    }

    public String pickOneRandomCardFilter() throws InterruptedException {
        Random rand = new Random();
        WebElement randVideo = videoCards.get(rand.nextInt(videoCards.size()));
        String nameVideoCard = randVideo.getAttribute("for");
        randVideo.click();
        Thread.sleep(2222);
        return nameVideoCard;
    }

    public List<LaptopsItems> setLaptops() {
        List<LaptopsItems> productList = new ArrayList<>();
        Actions actions = new Actions(webDriver);
        for (WebElement laptop: laptops
             ) {
            webDriverWait.until(ExpectedConditions.visibilityOf(laptop));
            actions.moveToElement(laptop).build().perform();
            String description =laptop.findElement(By.xpath(DESCRIPTION_LOCATOR)).getText();
            System.out.println(description);
            String name = laptop.findElement(By.xpath(NAME_LOCATOR)).getAttribute("title");
            System.out.println(name);
            String price = laptop.findElement(By.xpath(PRICE_LOCATOR)).getText();
            System.out.println(price);
            String status = laptop.findElement(By.xpath(STATUS_LOCATOR)).getText();
            System.out.println(status);
            LaptopsItems laptopsItems =new LaptopsItems(name,price,status,description);
            productList.add(laptopsItems);
        }
        return productList;
    }
    public List<String> resultDescriptions() {
        List<String> descriptions = new ArrayList<>();
        Actions actions = new Actions(webDriver);
        for (WebElement laptop: laptops
        ) {
            webDriverWait.until(ExpectedConditions.visibilityOf(laptop));
            actions.moveToElement(laptop).build().perform();
            String description =laptop.findElement(By.xpath(DESCRIPTION_LOCATOR)).getText();
            System.out.println(description);
            descriptions.add(description);
        }
        return descriptions;
    }

}


