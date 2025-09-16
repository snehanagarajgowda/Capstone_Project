package com.automationexercise.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.*;

public class ExcelUtilities {

    public static Object[][] getdata(String filepath, String sheetName, String tcId) throws IOException {
        FileInputStream fis = new FileInputStream(filepath);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        List<Object[]> dataList = new ArrayList<>();

        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next(); // skip header row

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Cell tcCell = row.getCell(0); // first column = TC_ID
            if (tcCell != null && tcCell.getStringCellValue().trim().equalsIgnoreCase(tcId)) {

                // collect the rest of the columns into an array
                int colCount = row.getLastCellNum();
                Object[] rowData = new Object[colCount - 1]; // exclude TC_ID column

                for (int i = 1; i < colCount; i++) {
                    Cell cell = row.getCell(i);
                    rowData[i - 1] = getCellValue(cell);
                }

                dataList.add(rowData);
            }
        }

        workbook.close();
        fis.close();

        Object[][] dataArray = new Object[dataList.size()][];
        return dataList.toArray(dataArray);
    }

    private static Object getCellValue(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING: return cell.getStringCellValue();
            case NUMERIC: return cell.getNumericCellValue();
            case BOOLEAN: return cell.getBooleanCellValue();
            default: return "";
        }
    }
}