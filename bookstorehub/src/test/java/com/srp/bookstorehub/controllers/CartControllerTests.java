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

import java.util.ArrayList;
import java.util.List;


@WebMvcTest(CartController.class)
class CartControllerTests {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	void getAllOrders_success() throws Exception {
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders
				.get("/cart/user/1001")
				.contentType(MediaType.APPLICATION_JSON));
		result.andExpect(status().isOk());
	}
	
	@Test
	void createOrder_success() throws Exception {
		Book book = new Book("4","Book 5", "James", "500");
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders
				.post("/cart/user/1001")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(book)));
		result.andExpect(status().isOk());
	}
	
	@Test
	void processOrder_success() throws Exception {
		List<Book> booklist = new ArrayList<>();
		booklist.add(new Book("4", "Bookkk 4", "Jimmy", "600"));
		booklist.add(new Book("3", "Bookkk 3", "Jimmy", "600"));
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders
				.post("/cart/user/1001/process")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(booklist)));
		result.andExpect(status().isOk());
	}
	
	@Test
	void deleteOrder_success() throws Exception {
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders
				.delete("/cart/user/1001/books/1")
				.contentType(MediaType.APPLICATION_JSON));
		result.andExpect(status().isOk());
	}

}
