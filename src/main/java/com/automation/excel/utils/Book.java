package com.automation.excel.utils;

/**
 * This class represents a book.
 * 
 * @author www.codejava.net
 */
public class Book {
	private String title;
	private String author;
	private double price;
	
	public Book() {
	}
	
	public Book(final String title, final String author, final double price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(final String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public void setAuthor(final String author) {
		this.author = author;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(final double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s - %f", this.title, this.author, this.price);
	}
}
