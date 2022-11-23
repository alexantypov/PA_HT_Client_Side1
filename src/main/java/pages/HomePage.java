package pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage{
    public WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//a[contains(text(),'Computers')]")
    private WebElement computerlogo;

    public HomePage openHomePage() {
        wait.until(ExpectedConditions.elementToBeClickable(computerlogo));
        computerlogo.click();
        return this;
    }
}


