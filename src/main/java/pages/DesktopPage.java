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
    @FindBy(xpath = "//h2[@class='product-title']/a")
    private WebElement DesktopProduct;

    public DesktopPage openDesktopPage() {
        wait.until(ExpectedConditions.elementToBeClickable(DesktopProduct));
        DesktopProduct.click();
        return this;
    }
}
