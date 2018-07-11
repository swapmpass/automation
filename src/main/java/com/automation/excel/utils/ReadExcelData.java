package com.automation.excel.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ReadExcelData {

  private XSSFWorkbook workbook;

  private ArrayList<HashMap<String, String>> deviceData = new ArrayList<>();

  private ArrayList<HashMap<String, String>> readExcel(final String filePath) {

    Cell cell = null;

    int dataRowNumber = 1;

    FileInputStream file = null;

    try {

      file = new FileInputStream(new File(filePath));

      workbook = new XSSFWorkbook(file);

      // Get first/desired sheet from the workbook
      final XSSFSheet sheet = workbook.getSheetAt(0);

      // Iterate through each rows one by one
      final Iterator<Row> rowIterator = sheet.iterator();
      rowIterator.next();

      int rowNumber = 0;

      while (rowIterator.hasNext()) {

        final Row row = rowIterator.next();

        final HashMap<String, String> dd = new HashMap();

        // For each row, iterate through all the columns
        final Iterator<Cell> cellIterator = row.cellIterator();

        while (cellIterator.hasNext()) {

          cell = cellIterator.next();

          // Check the cell type and format accordingly
          switch (cell.getColumnIndex()) {

            case 0:
              dd.put("TestName", cell.getStringCellValue().trim());
              print(rowNumber + ". TestName : " + dd.get("TestName"));
              break;

            case 1:
              dd.put("Rerun", cell.getStringCellValue().trim());
              print(rowNumber + ". Rerun : " + dd.get("Rerun"));
              break;
          }
        }
        dataRowNumber++;
        deviceData.add(dd);
        rowNumber++;
      }

      file.close();

    } catch (final Exception e) {
      System.out.println(e.getLocalizedMessage() + " for column index " + cell.getColumnIndex()
          + " data row number " + dataRowNumber);
    } finally {
      try {
        file.close();
      } catch (Exception e) {
        //nothing we can do
      }
    }
    return deviceData;
  }

  public ArrayList<HashMap<String, String>> getDataFromExcel(final String filePath) {
    return readExcel(filePath);
  }

  private void print(final String data) {
    System.out.println(data);
  }
}
