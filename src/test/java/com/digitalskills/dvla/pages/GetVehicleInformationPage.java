package com.digitalskills.dvla.pages;

import com.digitalskills.dvla.util.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetVehicleInformationPage {

    @FindBy(css = "a[role='button']")
    private WebElement startNowButton;

    private WebDriver driver;

    public GetVehicleInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitForPageLoad();
    }

    private void waitForPageLoad() {
        WebDriverWait webDriverWait = WebDriverUtils.getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOf(startNowButton));
    }

    public VehicleInquiryPage clickStartNow() {
        startNowButton.click();
        return new VehicleInquiryPage(driver);
    }

}