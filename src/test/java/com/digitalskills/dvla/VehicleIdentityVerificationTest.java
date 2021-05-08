package com.digitalskills.dvla;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.digitalskills.dvla.constant.FileMimeType;
import com.digitalskills.dvla.model.FileInfo;
import com.digitalskills.dvla.model.Vehicle;
import com.digitalskills.dvla.pages.ConfirmVehiclePage;
import com.digitalskills.dvla.pages.GetVehicleInformationPage;
import com.digitalskills.dvla.pages.VehicleInquiryPage;
import com.digitalskills.dvla.service.FileReaderService;
import com.digitalskills.dvla.service.VehicleDetailsReaderService;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static com.digitalskills.dvla.util.WebDriverUtils.getWebDriver;

public class VehicleIdentityVerificationTest extends BaseTest {

    private FileReaderService fileReaderService;
    private VehicleDetailsReaderService vehicleDetailsReaderService;

    @Before
    public void setUpBeforeEachTest() {
        super.setUpBeforeEachTest();

        fileReaderService = new FileReaderService();
        vehicleDetailsReaderService = new VehicleDetailsReaderService();
    }

    @Test
    public void testThatVehicleDetailsMatchWithVehicleRegistrationFiles() throws IOException {
        List<FileInfo> files = fileReaderService.readFiles(FileMimeType.NEW_EXCEL);

        for (FileInfo fileInfo : files) {
            testThatVehicleDetailsMatchWithVehicleRegistrationFile(fileInfo);
        }
    }

    private void testThatVehicleDetailsMatchWithVehicleRegistrationFile(FileInfo fileInfo) throws IOException {
        List<Vehicle> vehicles = vehicleDetailsReaderService.readFile(fileInfo);

        GetVehicleInformationPage getVehicleInformationPage = navigateToGetVehicleInformationPage();
        VehicleInquiryPage vehicleInquiryPage = getVehicleInformationPage.clickStartNow();

        for (Vehicle vehicle : vehicles) {
            vehicleInquiryPage.enterRegistrationNumber(vehicle.getRegNumber());

            ConfirmVehiclePage confirmVehiclePage = vehicleInquiryPage.clickContinueButton();
            assertEquals(confirmVehiclePage.getVehicleMake(), vehicle.getMake());
            assertEquals(confirmVehiclePage.getVehicleColour(), vehicle.getColour());

            takeScreenshot(vehicle.getMake() + " " + vehicle.getColour());

            confirmVehiclePage.restartSearch();
        }
    }

    private void takeScreenshot(String targetFileName) throws IOException {
        File scrFile = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("src//test//java//com//digitalskills//dvla//screenshots//" + getCurrentTimestamp() + " - " + targetFileName + ".jpg"));
    }

    private String getCurrentTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return LocalDateTime.now().format(formatter);
    }

}