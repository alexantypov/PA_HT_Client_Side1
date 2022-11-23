package pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DesktopPage extends HomePage{
    public DesktopPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "\"//div[@class='picture']//a[@href='#build']\"")
    private WebElement DesktopProduct;

    @FindBy(xpath = "\"//div[@class='picture']//a[@href='#build']\"")
    private WebElement DesktopDescription;

    public DesktopPage openDesktopPage() {
        wait.until(ExpectedConditions.elementToBeClickable(DesktopProduct));
        waitUntilPageIsFullyLoaded(wait);
        perfNavigationTiming.writeToInflux("DesktopPage");
        log.info("Desktop page is loaded");
        DesktopProduct.click();
        return this;
    }

    public DesktopPage openFirstDesktop() {
        String firstDesktopInList = DesktopProduct.get(0).getText();
        Log.info("First desktop: " +firstDesktopInList);
        DesktopProduct.get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable(DesktopDescription));
        perfNavigationTiming.writeToInflux("DesktopDescription");
        log.info("Desktop  description page is loaded");
        DesktopDescription.click();
        return this;
    }
}
