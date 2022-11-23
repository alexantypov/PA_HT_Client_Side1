package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ComputerPage extends HomePage{
    public ComputerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//img[@alt=\'Picture for category Desktops\']")
    private WebElement DesktopBanner;

    public ComputerPage openComputerPage() {
        wait.until(ExpectedConditions.elementToBeClickable(DesktopBanner));
        waitUntilPageIsFullyLoaded(wait);
        perfNavigationTiming.writeToInflux("ComputerPage");
        log.info("Computer page is loaded");
        DesktopBanner.click();
        return this;
    }
}
