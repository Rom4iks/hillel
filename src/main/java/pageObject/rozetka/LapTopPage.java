package pageObject.rozetka;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.unitils.thirdparty.org.apache.commons.io.FileUtils;
import pageObject.AbstractPage;
import utills.LaptopsItems;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;



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



    public String pickOneRandomCardFilter() throws InterruptedException, IOException {

        WebElement randVideo = videoCards.get((int)(Math.random()*videoCards.size()));
        String nameVideoCard = randVideo.getAttribute("for");
        Thread.sleep(2000);
        randVideo.click();
        return nameVideoCard;
    }

    public List<LaptopsItems> setLaptops() throws IOException {
        List<LaptopsItems> productList = new ArrayList<>();
        BufferedWriter br= new BufferedWriter(new FileWriter("my.txt"));
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
            String name = laptop.findElement(By.xpath(NAME_LOCATOR)).getAttribute("title");
            String price = laptop.findElement(By.xpath(PRICE_LOCATOR)).getText();
            String status = laptop.findElement(By.xpath(STATUS_LOCATOR)).getText();
            //Get full screenShot
            File source = ts.getScreenshotAs(OutputType.FILE);
            BufferedImage fullImg = ImageIO.read(source);

            // Get the location of element on the page
            Point point = laptop.getLocation();

            // Get width and height of the element
            int eleWidth = laptop.getSize().getWidth();
            int eleHeight = laptop.getSize().getHeight();

            // Crop the entire page screenshot to get only element screenshot
            BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
                    eleWidth, eleHeight);
            ImageIO.write(eleScreenshot, "png", source);

            // Copy the element screenshot to disk
            FileUtils.copyFile(source,new File("C:\\Users\\Roman_Ilchenko1\\Desktop\\ScreenShots\\"+name+".png"));

            LaptopsItems laptopsItems =new LaptopsItems (name,description,price,status);
            productList.add(laptopsItems);
        }

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
            descriptions.add(description);
        }

        return descriptions;
    }

}


