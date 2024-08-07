package com.srp.bookstorehub.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.srp.bookstorehub.dto.Book;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(BookController.class)
class BookControllerTests {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	void getAllBooks_success() throws Exception {
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders
				.get("/books")
				.contentType(MediaType.APPLICATION_JSON));
		result.andExpect(status().isOk());
	}
	
	@Test
	void getBook_success() throws Exception {
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders
				.get("/books/1")
				.contentType(MediaType.APPLICATION_JSON));
		result.andExpect(status().isOk());
	}

	@Test
	void createBook_success() throws Exception {
		Book book = new Book("Book 5", "James", "500");
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders
				.post("/books")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(book)));
		result.andExpect(status().isOk());
	}
	
	@Test
	void updateBook_success() throws Exception {
		
		Book book = new Book("4", "Bookkk 4", "Jimmy", "600");
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders
				.put("/books")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(book)));
		result.andExpect(status().isOk());
	}
	
	@Test
	void deleteBook_success() throws Exception {
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders
				.delete("/books/1")
				.contentType(MediaType.APPLICATION_JSON));
		result.andExpect(status().isOk());
	}

}
