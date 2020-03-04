package tests.wikipediaHW;

import org.junit.Test;
import pageObject.wikipedia.WikiMainPage;
import tests.BaseTest;

import java.io.IOException;

public class WikiPediaTests extends BaseTest {

    @Test
    public void CollectAllImgs() throws IOException, InterruptedException {
        String url= "https://en.wikipedia.org/wiki/Main_Page";
        webDriver.get(url);
        WikiMainPage wikiMainPage = new WikiMainPage(webDriver);
//        wikiMainPage.moveToAllPic();
        wikiMainPage.pictureSnapShots("C:\\Users\\Roman_Ilchenko1\\Desktop\\ScreenShots");
        Thread.sleep(2000);
    }
}
