package com.srp.bookstorehub.datastore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import com.srp.bookstorehub.dto.Book;

public class BookStoreDataStore {
	public static List<Book> BOOKS = new ArrayList<>();
	
	public static Map<String, List<String>> USER_ORDER = new HashMap<>();
	
	public static Map<String, String> USER_DETAILS = new HashMap<>();
	
	static {
		BOOKS.add(new Book("1", "Book1", "Ram", "100"));
		BOOKS.add(new Book("2", "Book2", "John", "200"));
		BOOKS.add(new Book("3", "Book3", "Jenny", "300"));
		BOOKS.add(new Book("4", "Book4", "Krishna", "400"));
	}
	
	static {
		USER_ORDER.put("1001", new ArrayList<>());
		USER_ORDER.put("1002", new ArrayList<>());
		USER_ORDER.put("1003", new ArrayList<>());
		
		USER_ORDER.get("1001").add("1");
		USER_ORDER.get("1001").add("2");
	}
	
	static {
		USER_DETAILS.put("1001", "1001");
		USER_DETAILS.put("1002", "1002");
		USER_DETAILS.put("1003", "1003");
	}
	
}
