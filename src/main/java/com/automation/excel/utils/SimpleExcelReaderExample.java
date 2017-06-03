package com.automation.excel.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * A dirty simple program that reads an Excel file.
 *
 * @author www.codejava.net
 */
public class SimpleExcelReaderExample {

	public static void main(final String[] args) throws IOException {
		final String excelFilePath = "./src/main/resource/Books.xlsx";
		final FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		final Workbook workbook = new XSSFWorkbook(inputStream);
		final Sheet firstSheet = workbook.getSheetAt(0);
		final Iterator<Row> iterator = firstSheet.iterator();

		while (iterator.hasNext()) {
			final Row nextRow = iterator.next();
			final Iterator<Cell> cellIterator = nextRow.cellIterator();

			while (cellIterator.hasNext()) {
				final Cell cell = cellIterator.next();

				final org.apache.poi.ss.usermodel.CellType cellType = cell.getCellTypeEnum();

				switch (cellType) {
					case STRING:
						System.out.print(cell.getStringCellValue());
						break;
					case BOOLEAN:
						System.out.print(cell.getBooleanCellValue());
						break;
					case NUMERIC:
						System.out.print(cell.getNumericCellValue());
						break;
					default:
						break;
				}
				System.out.print(" - ");
			}
			System.out.println();
		}

		workbook.close();
		inputStream.close();
	}
	
}
