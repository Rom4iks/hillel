package tests.yahoo;

import org.junit.Assert;
import org.junit.Test;
import pageObject.yahoo.YahooMainPage;
import pageObject.yahoo.YahooSearchResult;
import tests.BaseTest;

public class YahooSearchTest extends BaseTest {

    @Test
    public void VerifyYahooSearchResultOnFirstPage() throws Exception {
        webDriver.get( propertyHelper.readProperty("yahoo.site.url"));
        YahooMainPage mPage= new YahooMainPage(webDriver);
        YahooSearchResult srPage= mPage.typeText("Reserved");
        boolean result= srPage.findInputViaPages("jeans", false);
        Assert.assertFalse("Not appears on First Page",result);
    }
    @Test
    public void VerifyYahooSearchResultOnAllPages() throws Exception {
        webDriver.get( propertyHelper.readProperty("yahoo.site.url"));
        YahooMainPage mPage= new YahooMainPage(webDriver);
        YahooSearchResult srPage= mPage.typeText("Reserved");
        boolean result= srPage.findInputViaPages("ZARA", true);
        Assert.assertFalse("Your request not found",result);

    }

}
