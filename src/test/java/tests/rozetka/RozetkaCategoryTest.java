package tests.rozetka;


import org.junit.Test;
import pageObject.rozetka.LapTopPage;
import pageObject.rozetka.RozetkaMainPage;
import java.io.IOException;


public class RozetkaCategoryTest extends BaseTest {


    @Test
    public void verifyRozetkaCategorySelect() throws InterruptedException, IOException {
        String url = "https://rozetka.com.ua/";
        webDriver.get(url);
        RozetkaMainPage mainPage = new RozetkaMainPage(webDriver);
        mainPage.selectDellLaptops();
        LapTopPage lapTopPage= new LapTopPage(webDriver);
        lapTopPage.pickOneRandomCardFilter();
        lapTopPage.description();
        lapTopPage.setLaptops();
        Thread.sleep(2000);

    }
}
