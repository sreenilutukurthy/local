package com.digitalskills.dvla.service;

import com.digitalskills.dvla.model.FileInfo;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.digitalskills.dvla.model.Vehicle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VehicleDetailsReaderService {

    public List<Vehicle> readFile(FileInfo fileInfo) throws IOException {
        if ("CSV".equalsIgnoreCase(fileInfo.getExtension())) {
            return readFromCSVFile(fileInfo);
        } else if ("XLS".equalsIgnoreCase(fileInfo.getExtension())) {
            return readFromOldExcelFile(fileInfo);
        } else if ("XLSX".equalsIgnoreCase(fileInfo.getExtension())) {
            return readFromNewExcelFile(fileInfo);
        } else {
            throw new IllegalArgumentException("Only support CSV, XLS and XLSX files");
        }
    }

    public List<Vehicle> readFromCSVFile(FileInfo fileInfo) {
        // Can be developed as Enhancement
        return Collections.emptyList();
    }

    public List<Vehicle> readFromOldExcelFile(FileInfo fileInfo) {
        // Can be developed as Enhancement
        return Collections.emptyList();
    }

    private List<Vehicle> readFromNewExcelFile(FileInfo fileInfo) throws IOException {
        List<Vehicle> vehicles = new ArrayList<>();

        File excelFile = new File(fileInfo.getFilePath());
        FileInputStream fis = new FileInputStream(excelFile);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0); // Assuming that there is only one sheet

        for (Row row : sheet) {
            // Ignoring the heading row
            if (row.getRowNum() == 0) {
                continue;
            }

            String regNumber = row.getCell(0).getStringCellValue();
            String make = row.getCell(1).getStringCellValue();
            String colour = row.getCell(2).getStringCellValue();
            double year = row.getCell(3).getNumericCellValue();

            vehicles.add(new Vehicle(regNumber, make, colour, year));
        }

        workbook.close();
        fis.close();

        return vehicles;
    }

}