package com.digitalskills.dvla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.digitalskills.dvla.util.WebDriverUtils;

public class VehicleInquiryPage {

    @FindBy(css = "#wizard_vehicle_enquiry_capture_vrn_vrn")
    private WebElement regNumberTextField;

    @FindBy(css = "#submit_vrn_button")
    private WebElement continueButton;

    private WebDriver driver;

    public VehicleInquiryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitForPageLoad();
    }

    private void waitForPageLoad() {
        WebDriverWait webDriverWait = WebDriverUtils.getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOf(continueButton));
    }

    public void enterRegistrationNumber(String regNumber) {
        regNumberTextField.sendKeys(regNumber);
    }

    public ConfirmVehiclePage clickContinueButton() {
        continueButton.click();
        return new ConfirmVehiclePage(driver);
    }

}