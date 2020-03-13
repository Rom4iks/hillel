package tests.googleHW;

import org.junit.Assert;
import org.junit.Test;
import pageObject.google.GoogleMainPage;
import pageObject.google.SearchResult;
import tests.BaseTest;

public class VerifyGoogleSearch extends BaseTest {

    @Test
    public void VerifyGoogleSearchResultOnFirstPage() throws Exception {
        webDriver.get( propertyHelper.readProperty("google.site.url"));

        GoogleMainPage mPage= new GoogleMainPage(webDriver);
        SearchResult srPage= mPage.typeText("резервд");
        boolean result= srPage.findInputViaPages("нашли", false);
          Assert.assertFalse("Not appears on First Page",result);
    }
    @Test
    public void VerifyGoogleSearchResultOnAllPages() throws Exception {
        webDriver.get( propertyHelper.readProperty("google.site.url"));
        GoogleMainPage mPage= new GoogleMainPage(webDriver);
        SearchResult srPage= mPage.typeText("резервд");
        boolean result= srPage.findInputViaPages("Gloria", true);
        Assert.assertFalse("Your request not found",result);

    }
}
