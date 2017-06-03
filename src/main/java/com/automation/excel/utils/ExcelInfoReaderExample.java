package com.automation.excel.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * A program demonstrates reading other information of workbook, sheet and cell.
 * 
 * @author www.codejava.net
 */
public class ExcelInfoReaderExample {
	
	public static void main(final String[] args) throws IOException {
		final String excelFilePath = "Books.xlsx";
		final FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		final Workbook workbook = new XSSFWorkbook(inputStream);
		final Sheet sheet = workbook.getSheetAt(0);
		final String sheetName = sheet.getSheetName();

		System.out.println("Sheet name = " + sheetName);

		final int numberOfSheets = workbook.getNumberOfSheets();
		for (int i = 0; i < numberOfSheets; i++) {
			final Sheet aSheet = workbook.getSheetAt(i);
			System.out.println(aSheet.getSheetName());
		}

		final Comment cellComment = sheet.getCellComment(new CellAddress(new CellAddress(2, 2)));
		System.out.println("comment: " + cellComment.getString());

		workbook.close();
		inputStream.close();
	}
	
}
