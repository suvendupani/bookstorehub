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

}
