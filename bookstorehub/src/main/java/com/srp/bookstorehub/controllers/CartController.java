package com.srp.bookstorehub.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srp.bookstorehub.datastore.BookStoreDataStore;
import com.srp.bookstorehub.dto.Book;
import static com.srp.bookstorehub.datastore.BookStoreDataStore.BOOKS;
import static com.srp.bookstorehub.datastore.BookStoreDataStore.USER_ORDER;;

@CrossOrigin
@RestController
@RequestMapping("/cart/user/{userId}")
public class CartController {
	static Map<String, Book> bookmap = BOOKS.stream().collect(Collectors.toMap(b->b.getId(), b->b,(b1,b2) -> b1));
	
	@GetMapping
	public List<Book> getAllOrders(@PathVariable String userId){
		return USER_ORDER.get(userId).stream().map(i -> bookmap.get(i)).toList();
	}
	
	
	@PostMapping
	public ResponseEntity<String> addOrder(@PathVariable String userId,@RequestBody Book book){
		//bookmap.get(book.getId());
		USER_ORDER.get(userId).add(book.getId());
		return ResponseEntity.ok("order created successfully");
	}
	
	@PostMapping("/process")
	public ResponseEntity<String> processOrder(@PathVariable String userId, @RequestBody List<Book> book){
		USER_ORDER.get(userId).clear();
		return ResponseEntity.ok("Order processed successfully");
	}
	
	
	@DeleteMapping("/book/{bookId}")
	public ResponseEntity<String> removeOrder(@PathVariable() String userId, @PathVariable String bookId){
		USER_ORDER.get(userId).remove(bookId);
		return ResponseEntity.ok("Book deleted successfully");
	}
}
