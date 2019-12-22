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

import java.io.FileWriter;
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
    @FindBy(xpath = "//a[contains(@class,'exponea-banner')]")
    private WebElement promoBlock;
    @FindBy(xpath = "//a[contains(@class,'exponea-banner')]//span[@class='exponea-close']")
    private WebElement closePromo;




    private static final String NAME_LOCATOR = ".//a[@class ='goods-tile__heading']"; //getAtribute("title")
    private static final String PRICE_LOCATOR = ".//span[@class ='goods-tile__price-value']"; //getText()
    private static final String STATUS_LOCATOR = ".//div[contains(@class,'goods-tile__availability')]"; //getText()
    private static final String DESCRIPTION_LOCATOR = ".//p[contains(@class,'goods-tile__description')]"; //getText()


    public List<String> addToTxtVideo(){
        List<String> textCategory = new ArrayList<>();
        for (WebElement videoCard : videoCards
        ) {
            String text = videoCard.getAttribute("for");
            System.out.println(text);
            textCategory.add(text);
        }
        return textCategory;
    }

    public String pickOneRandomCardFilter() throws InterruptedException {

        WebElement randVideo = videoCards.get((int)(Math.random()*videoCards.size()));
        String nameVideoCard = randVideo.getAttribute("for");
        randVideo.click();
        Thread.sleep(3000);

        return nameVideoCard;
    }

    public List<LaptopsItems> setLaptops() throws IOException {
        List<LaptopsItems> productList = new ArrayList<>();
        BufferedWriter br= new BufferedWriter(new FileWriter("C:\\my.txt"));
        Actions actions = new Actions(webDriver);
        try{
            webDriverWait.until(ExpectedConditions.visibilityOf(promoBlock));
            closePromo.click();
        }catch (Exception e){
            System.out.println("No promo this time");}

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
            br.write(name);
            br.newLine();
            br.write(status);
            br.newLine();
            br.write(price);
            br.newLine();
            br.write(description);
            br.newLine();

            LaptopsItems laptopsItems =new LaptopsItems (name,description,price,status);
            productList.add(laptopsItems);
        }
        br.close();
        return productList;
    }


    public List<String> resultDescriptions() {
        List<String> descriptions = new ArrayList<>();
        Actions actions = new Actions(webDriver);

        try{
            webDriverWait.until(ExpectedConditions.visibilityOf(promoBlock));
            closePromo.click();
        }catch (Exception e){
            System.out.println("No promo this time");}


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


