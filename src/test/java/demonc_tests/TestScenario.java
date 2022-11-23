package demonc_tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.ComputerPage;
import pages.DesktopPage;
import pages.HomePage;
import java.util.HashMap;
import java.util.Map;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;


public class TestScenario {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }
    public static HomePage HOME_PAGE;
    public static ComputerPage COMPUTER_PAGE;
    public static DesktopPage DESKTOP_PAGE;

    private static final String DEMONC_URL = "https://demo.nopcommerce.com/";

    @BeforeTest
    public void profileSetUp() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(DEMONC_URL);
        HOME_PAGE = new HomePage(getDriver());
        COMPUTER_PAGE = new ComputerPage(getDriver());
        DESKTOP_PAGE = new DesktopPage(getDriver());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
