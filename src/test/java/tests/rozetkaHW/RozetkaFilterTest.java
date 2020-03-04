package tests.rozetkaHW;


import org.junit.Assert;
import org.junit.Test;
import pageObject.rozetka.LapTopPage;
import pageObject.rozetka.RozetkaMainPage;
import tests.BaseTest;

import java.io.IOException;
import java.util.List;


public class RozetkaFilterTest extends BaseTest {


    @Test
    public void verifyPriceFilter() throws InterruptedException, IOException {
        String url = "https://rozetka.com.ua/";
        webDriver.get(url);
        RozetkaMainPage mainPage = new RozetkaMainPage(webDriver);
        mainPage.selectDellLaptops();
        LapTopPage lapTopPage = new LapTopPage(webDriver);
        lapTopPage.setPriceFilter("3000","4000");
        List<Integer> prices = lapTopPage.collectPricesOfLaptops();
        for (Integer price: prices
             ) {
           if ((price>4000)||(price<2000)){
                Assert.fail("Filter not worked correctly");
           }
        }
        Thread.sleep(2000);

    }
}
