package com.digitalskills.dvla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.digitalskills.dvla.util.WebDriverUtils;

import java.util.List;

public class ConfirmVehiclePage {

    @FindBy(xpath = "//li[@class ='list-summary-item']")
    private List<WebElement> vehicleDetails;

    @FindBy(css = "div[class='reg-mark-sm']")
    private WebElement vehicleRegNumber;

    @FindBy(xpath = "(//dd)[2]")
    private WebElement vehicleMake;

    @FindBy(xpath = "(//dd)[3]")
    private WebElement vehicleColour;

    @FindBy(css = "#no-vehicle-confirm")
    private WebElement noSearchAgainRadioButton;

    @FindBy(css = "#capture_confirm_button")
    private WebElement continueButton;

    private WebDriver driver;

    public ConfirmVehiclePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitForPageLoad();
    }

    private void waitForPageLoad() {
        WebDriverWait webDriverWait = WebDriverUtils.getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOf(continueButton));
    }

    public String getVehicleRegNumber() {
        return vehicleRegNumber.getText();
    }

    public String getVehicleMake() {
        return vehicleMake.getText();
    }

    public String getVehicleColour() {
        return vehicleColour.getText();
    }

    public VehicleInquiryPage restartSearch() {
        noSearchAgainRadioButton.click();
        continueButton.click();
        return new VehicleInquiryPage(driver);
    }

}