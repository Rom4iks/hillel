package pageObject.wikipedia;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.unitils.thirdparty.org.apache.commons.io.FileUtils;
import pageObject.AbstractPage;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class WikiMainPage extends AbstractPage {

    @FindBys(@FindBy(xpath = "//img"))
    private List<WebElement> listOfImgs;

    public WikiMainPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void pictureSnapShots(String path) throws IOException, InterruptedException {

            for (WebElement img : listOfImgs
            ) {
                actions.moveToElement(img).perform();
                Screenshot myScreenshot = new AShot().takeScreenshot(webDriver, img);
                ImageIO.write(myScreenshot.getImage(),"png",new File(path +"\\"+ img.getAttribute("alt") + ".png"));
            }
        }

        public void moveToAllPic() throws InterruptedException {
            for (WebElement img: listOfImgs
                 ) {
                actions.moveToElement(img).build().perform();
                Thread.sleep(500);

            }
        }

    }
