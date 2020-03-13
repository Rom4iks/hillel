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

        webDriver.get(propertyHelper.readProperty("rozetka.site.url"));
        RozetkaMainPage mainPage = new RozetkaMainPage(webDriver);
        LapTopPage lapTopPage = mainPage.selectDellLaptops();
        Integer minPrice = 5500;
        Integer maxPrice = 5900;
        lapTopPage.setPriceFilter(minPrice,maxPrice);
        List<Integer> prices = lapTopPage.collectPricesOfLaptops();
        prices.forEach(price -> Assert.assertFalse("Something goes wrong",(price<minPrice)||(price>maxPrice)));

    }
}
