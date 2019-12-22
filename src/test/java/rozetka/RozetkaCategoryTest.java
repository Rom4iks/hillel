package rozetka;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.rozetka.LapTopPage;
import pageObject.rozetka.MainPage;
import utills.LaptopsItems;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class RozetkaCategoryTest {

    private WebDriver webDriver;
    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize(); }

    @After
    public void shutDownDriver(){
        webDriver.close();
        webDriver.quit();
    }
    @Test
    public void verifyRozetkaCategorySelect() throws IOException, InterruptedException {
        String url = "https://rozetka.com.ua/";
        webDriver.get(url);
        MainPage mainPage = new MainPage(webDriver);
        mainPage.selectDellLaptops();
        LapTopPage lapTopPage= new LapTopPage(webDriver);
        String videocategory =lapTopPage.pickOneRandomCardFilter();
//        lapTopPage.setLaptops();
        List<String> descriptions = lapTopPage.resultDescriptions();
        Assert.assertTrue(descriptions.contains(videocategory));



    }
}
