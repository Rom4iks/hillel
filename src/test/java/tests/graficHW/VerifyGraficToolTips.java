package tests.graficHW;

import org.junit.Test;
import pageObject.Grafic.GraficPage;
import tests.BaseTest;

public class VerifyGraficToolTips extends BaseTest {
    @Test
    public void verifyGreyGrafic() throws InterruptedException {
        String url = "https://www.highcharts.com/demo/combo-timeline";
        webDriver.get(url);
        GraficPage gp = new GraficPage(webDriver);
        gp.actionGreyGrafic();
        gp.actionGreenGrafic();
        gp.actionBlueGrafic();
    }
    @Test
    public void verifyGreenGrafic() throws InterruptedException {
        String url = "https://www.highcharts.com/demo/combo-timeline";
        webDriver.get(url);
        GraficPage gp = new GraficPage(webDriver);
        gp.actionGreenGrafic();
    }
    @Test
    public void verifyBlueGrafic() throws InterruptedException {
        String url = "https://www.highcharts.com/demo/combo-timeline";
        webDriver.get(url);
        GraficPage gp = new GraficPage(webDriver);
        gp.actionBlueGrafic();
    }
}
