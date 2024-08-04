package com.srp.bookstorehub.dto;

public class Book {
	String id;
	String title;
	String author;
	String price;
	
	Book(){
		
	}
	public Book(String title, String author, String price){
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	public Book(String id, String title, String author, String price){
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder bldr = new StringBuilder();
		bldr.append("id : " + this.id);
		bldr.append(" title : " + this.title);
		bldr.append(" author : " + this.author);
		bldr.append(" price : " + this.price);

		return bldr.toString();
	}
}
