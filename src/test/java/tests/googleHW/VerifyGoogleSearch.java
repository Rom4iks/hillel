package tests.googleHW;

import org.junit.Assert;
import org.junit.Test;
import pageObject.google.GoogleMainPage;
import pageObject.google.SearchResult;
import tests.BaseTest;
import utills.PropertyHelper;

import javax.swing.plaf.TableHeaderUI;
import java.util.List;

public class VerifyGoogleSearch extends BaseTest {

    @Test
    public void VerifySearchOnFirstPage() throws Exception {
//        PropertyHelper ph = new PropertyHelper();
//        webDriver.get(ph.readProperty("google.site.url"));
        webDriver.get("https://www.google.com/");
        GoogleMainPage mPage= new GoogleMainPage(webDriver);
        SearchResult srPage= mPage.typeText("резервд");
        srPage.findFirmName("Reserved");
        Thread.sleep(1000);

//        Assert.assertTrue("Not appears on First Page",srPage.findFirmName("Борис"));




    }
    @Test
    public void VerifySearchNotOnFirstPage(){


    }
    @Test
    public void VerifyNegativeSearch(){


    }

}
