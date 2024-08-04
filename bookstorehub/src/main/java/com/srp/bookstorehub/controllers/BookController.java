package com.srp.bookstorehub.controllers;

import java.util.Arrays;
import java.util.List;

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

@CrossOrigin
@RestController
@RequestMapping("/books")
public class BookController {
	Integer counter =100;
	
	@GetMapping
	public List<Book> getAllBooks(){
		return BOOKS;
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity<Book> getBook(@PathVariable String bookId){
		List<Book> books =  BOOKS.stream().filter(b-> bookId.equalsIgnoreCase(b.getId())).toList();
		/*
		 * if(books.isEmpty()) { return ResponseEntity<Book>.notFo; }
		 */
		return new ResponseEntity<Book>(books.get(0), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> createBook(@RequestBody Book book){
		book.setId(++counter +"");
		BOOKS.add(book);
		return ResponseEntity.ok("Book "+book.getTitle()+"created successfully");
	}
	
	@PutMapping
	public ResponseEntity<String> updateBookDetails(@RequestBody Book book){
		BOOKS.stream().filter(b-> book.getId().equalsIgnoreCase(b.getId())).forEach(b->{
			b.setAuthor(book.getAuthor());
			b.setPrice(book.getPrice());
			b.setTitle(book.getTitle());
			});
		return ResponseEntity.ok("Book "+book.getTitle()+"updated successfully");
	}
	
	@DeleteMapping("/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable String bookId){
		BOOKS.removeIf(b->b.getId().equalsIgnoreCase(bookId));
		return ResponseEntity.ok("Book deleted successfully");
	}
}
