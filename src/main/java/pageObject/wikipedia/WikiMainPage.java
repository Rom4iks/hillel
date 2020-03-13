package pageObject.wikipedia;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pageObject.AbstractPage;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WikiMainPage extends AbstractPage {

    @FindBys(@FindBy(xpath = "//img"))
    private List<WebElement> listOfAllImgsOnThePage;

    @FindBys(@FindBy(css = "*.MainPageBG img"))
    private List<WebElement> listOfContentImgs;

    public WikiMainPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void pictureSnapShots(String path, boolean allPictures) throws IOException {
        if (allPictures) {
            for (WebElement img : listOfAllImgsOnThePage
            ) {
                actions.moveToElement(img).perform();
                Screenshot myScreenshot = new AShot().takeScreenshot(webDriver, img);
                ImageIO.write(myScreenshot.getImage(), "png", new File(path + "\\" + img.getAttribute("alt") + ".png"));
            }
        } else {
            for (WebElement img : listOfContentImgs
            ) {
                actions.moveToElement(img).perform();
                Screenshot myScreenshot = new AShot().takeScreenshot(webDriver, img);
                ImageIO.write(myScreenshot.getImage(), "png", new File(path + "\\" + img.getAttribute("alt") + ".png"));
            }
        }
    }

    public void moveToAllPic() throws InterruptedException {
        for (WebElement img : listOfAllImgsOnThePage
        ) {
            actions.moveToElement(img).build().perform();
            Thread.sleep(500);

        }
    }

    public void savePicturesFromWebSite(String path, boolean allPictures) {
        if (allPictures) {
            for (WebElement img :
                    listOfAllImgsOnThePage) {
                img.getAttribute("src");
                try (InputStream in = new URL(img.getAttribute("src")).openStream()) {

                    Files.copy(in, Paths.get(String.valueOf(new File(path + "\\" + img.getAttribute("alt") + ".png"))));

                } catch (IOException e) {
                    System.out.println("Please check your folder, pictures already exist");
                }
            }
        } else {
            for (WebElement img :
                    listOfContentImgs) {
                img.getAttribute("src");
                try (InputStream in = new URL(img.getAttribute("src")).openStream()) {

                    Files.copy(in, Paths.get(path + "\\" + img.getAttribute("alt") + ".png"));

                } catch (IOException e) {
                    System.out.println("Please check your folder, pictures already exist");
                }
            }
        }
    }
}