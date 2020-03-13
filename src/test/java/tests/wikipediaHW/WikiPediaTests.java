package tests.wikipediaHW;

import org.junit.Test;
import pageObject.wikipedia.WikiMainPage;
import tests.BaseTest;

import java.io.IOException;

public class WikiPediaTests extends BaseTest {

    @Test
    public void ScreenShotAllImgs() throws IOException, InterruptedException {
        webDriver.get(propertyHelper.readProperty("wikipedia.site.url"));
        WikiMainPage wikiMainPage = new WikiMainPage(webDriver);
        wikiMainPage.pictureSnapShots("C:\\Users\\Roman_Ilchenko1\\Desktop\\ScreenShots",false); // need to set path for saving pictures and true\false for AllPictures\ContentPictures
    }

    @Test
    public void CollectAllImgs() {
        webDriver.get(propertyHelper.readProperty("wikipedia.site.url"));
        WikiMainPage wikiMainPage = new WikiMainPage(webDriver);
        wikiMainPage.savePicturesFromWebSite("C:\\Users\\Roman_Ilchenko1\\Desktop\\ScreenShots", false); // need to set path for saving pictures and true\false for AllPictures\ContentPictures
    }
}
