package pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage{
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//div[2]/ul/li/a")
    private WebElement computerlogo;

    public HomePage openHomePage() {
        wait.until(ExpectedConditions.elementToBeClickable(computerlogo));
        perfNavigationTiming.writeToInflux("HomePage");
        log.info("Home page is loaded");
        computerlogo.click();
        return this;
    }
}


