package rozetka;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObject.rozetka.LapTopPage;
import pageObject.rozetka.MainPage;
import java.io.IOException;
import java.util.List;


public class RozetkaCategoryTest extends BaseTest {


    @Test
    public void verifyRozetkaCategorySelect() throws InterruptedException, IOException {
        String url = "https://rozetka.com.ua/";
        webDriver.get(url);
        MainPage mainPage = new MainPage(webDriver);
        mainPage.selectDellLaptops();
        LapTopPage lapTopPage= new LapTopPage(webDriver);
        String videocategory =lapTopPage.pickOneRandomCardFilter();
        lapTopPage.setLaptops();
        List<String> descriptions = lapTopPage.resultDescriptions();
        Assert.assertTrue(descriptions.contains(videocategory));

    }
}
