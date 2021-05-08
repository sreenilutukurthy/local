package com.digitalskills.dvla;

import com.digitalskills.dvla.pages.GetVehicleInformationPage;
import com.digitalskills.dvla.util.WebDriverUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

    private static final String VEHICLE_INFO_FROM_DVLA_URL = "https://www.gov.uk/get-vehicle-information-from-dvla";

    public GetVehicleInformationPage navigateToGetVehicleInformationPage() {
        WebDriver driver = WebDriverUtils.getWebDriver();
        driver.get(VEHICLE_INFO_FROM_DVLA_URL);

        return new GetVehicleInformationPage(driver);
    }

    @BeforeClass
    public static void setUp() {
        WebDriverUtils.initWebDriver();
    }

    @Before
    public void setUpBeforeEachTest() {
        WebDriverUtils.clearCookies();
    }

    @AfterClass
    public static void tearDown() {
        WebDriverUtils.quitWebDriver();
    }

}