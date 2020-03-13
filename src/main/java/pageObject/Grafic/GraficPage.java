package pageObject.Grafic;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pageObject.AbstractPage;

import java.util.List;

public class GraficPage extends AbstractPage {


    public GraficPage(WebDriver webDriver) {
        super(webDriver);
    }


    @FindBys(@FindBy(css = "g[aria-label='Revenue, series 2 of 7 with 60 data points. Y axis, values']>path"))
    List<WebElement> greyGrafic;

    @FindBys(@FindBy(css = "g[aria-label='Highsoft employees, series 3 of 7 with 14 data points. Y axis, Employees']>path"))
    List<WebElement> greenGrafic;

    @FindBys(@FindBy(css = "g[aria-label='Google search for highcharts, series 1 of 7. Line with 60 data points. Y axis, values']>path"))
    List<WebElement> blueGrafic;

    @FindBys(@FindBy(css = "g[class*='tool']>text>tspan"))
    List<WebElement> tooltipsElements;

    public void actionGreyGrafic() throws InterruptedException {
        Actions actions = new Actions(webDriver);
//        List<String> expectedTooltip = new ArrayList<>();
//        List<String> actualTooltip = new ArrayList<>();

        for (WebElement breakpoint : greyGrafic) {
            String tooltipText = "";
            actions.moveToElement(breakpoint).click().build().perform();
            Thread.sleep(100);
//
//            for (WebElement tooltip : tooltipsElements
//            ) {
//                tooltipText = tooltipText + " " + tooltip.getText();
//            }
//            actualTooltip.add(breakpoint.getAttribute("aria-label"));
//            expectedTooltip.add(tooltipText);
            System.out.println(tooltipText);

//        }
//        return expectedTooltip;
        }
    }
    public void actionGreenGrafic() throws InterruptedException {
        for (WebElement breakpoint : greenGrafic) {
            String tooltipText = "";
            actions.moveToElement(breakpoint).build().perform();
            Thread.sleep(100);
            for (WebElement tooltip : tooltipsElements
            ) {
                tooltipText = tooltipText + " " + tooltip.getText();
            }
            System.out.println(tooltipText);
        }
    }

    public void actionBlueGrafic() throws InterruptedException {
        Actions actions = new Actions(webDriver);
        for (WebElement breakpoint : blueGrafic) {
            StringBuilder tooltipText = new StringBuilder();

            actions.moveToElement(breakpoint).click().build().perform();
            Thread.sleep(100);
            for (WebElement tooltip : tooltipsElements
            ) {
                tooltipText.append(" ").append(tooltip.getText());
            }
            System.out.println(tooltipText);
        }
    }
}

