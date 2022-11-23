package demonc_tests;

import org.testng.annotations.Test;


public class DemoncTest extends TestScenario{


    @Test(priority = 1)
    public void openHomePage() {
        HOME_PAGE.openHomePage();
    }
    @Test(priority = 2)
    public void openComputerPage() {
        COMPUTER_PAGE.openComputerPage();
    }
    @Test(priority = 3)
    public void openDesktopPage() {
        DESKTOP_PAGE.openDesktopPage();
    }
    @Test(priority = 4)
    public void openFirstDesktop() {
        DESKTOP_PAGE.openFirstDesktop();
    }

}
