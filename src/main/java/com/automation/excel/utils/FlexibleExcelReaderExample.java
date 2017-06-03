package com.automation.excel.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * A test program demonstrates support of both XLS and XLSX formats.
 * 
 * @author www.codejava.net
 */
public class FlexibleExcelReaderExample {

	public List<Book> readBooksFromExcelFile(final String excelFilePath) throws IOException {
		final List<Book> listBooks = new ArrayList<>();

		final FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		final Workbook workbook = getWorkbook(inputStream, excelFilePath);

		final Sheet firstSheet = workbook.getSheetAt(0);
		final Iterator<Row> iterator = firstSheet.iterator();

		while (iterator.hasNext()) {
			final Row nextRow = iterator.next();
			final Iterator<Cell> cellIterator = nextRow.cellIterator();
			final Book aBook = new Book();

			while (cellIterator.hasNext()) {
				final Cell nextCell = cellIterator.next();
				final int columnIndex = nextCell.getColumnIndex();

				switch (columnIndex) {
				case 1:
					aBook.setTitle((String) getCellValue(nextCell));
					break;
				case 2:
					aBook.setAuthor((String) getCellValue(nextCell));
					break;
				case 3:
					aBook.setPrice((double) getCellValue(nextCell));
					break;
				}

			}
			listBooks.add(aBook);
		}

		workbook.close();
		inputStream.close();

		return listBooks;
	}

	private Object getCellValue(final Cell cell) {

		switch (cell.getCellTypeEnum()) {
		
			case STRING:
				return cell.getStringCellValue();
	
			case BOOLEAN:
				return cell.getBooleanCellValue();
	
			case NUMERIC:
				return cell.getNumericCellValue();
				
			default:
				break;
		}

		return null;
	}

	public static void main(final String[] args) throws IOException {
		final String excelFilePath = "Books.xlsx";
		final FlexibleExcelReaderExample reader = new FlexibleExcelReaderExample();
		final List<Book> listBooks = reader.readBooksFromExcelFile(excelFilePath);
		System.out.println(listBooks);
	}

	private Workbook getWorkbook(final FileInputStream inputStream, final String excelFilePath) throws IOException {
		Workbook workbook = null;

		if (excelFilePath.endsWith("xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		} else if (excelFilePath.endsWith("xls")) {
			workbook = new HSSFWorkbook(inputStream);
		} else {
			throw new IllegalArgumentException("The specified file is not Excel file");
		}
		return workbook;
	}
}
