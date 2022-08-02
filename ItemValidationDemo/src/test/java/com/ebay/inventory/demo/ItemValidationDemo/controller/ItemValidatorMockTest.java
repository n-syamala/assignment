package com.ebay.inventory.demo.ItemValidationDemo.controller;

import java.nio.charset.Charset;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class) 
@WebMvcTest
@AutoConfigureMockMvc
public class ItemValidatorMockTest {
	 @Autowired
	  private MockMvc mockMvc;

	@Test
	public void whenPostRequestToItemsAndValidItem_thenCorrectResponse() throws Exception {
	    MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
	    String item = "{\"siteID\": 10, \"title\" : \"tilteIsUnder85Chars\"}";
	    mockMvc.perform(MockMvcRequestBuilders.post("/items")
	      .content(item)
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(MockMvcResultMatchers.status().isOk())
	      .andExpect(MockMvcResultMatchers.content()
	        .contentType(textPlainUtf8));
	}

	@Test
	public void whenPostRequestToItemsAndInValidItem_thenCorrectResponse() throws Exception {
		 String item = "{\"siteID\": 10}";
	    mockMvc.perform(MockMvcRequestBuilders.post("/items")
	      .content(item)
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(MockMvcResultMatchers.status().isBadRequest())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.title", Is.is("Title is mandatory")))
	      .andExpect(MockMvcResultMatchers.content()
	        .contentType(MediaType.APPLICATION_JSON));
	    }
	}
