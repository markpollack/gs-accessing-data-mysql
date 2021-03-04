package com.example.accessingdatamysql;


import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
	properties = {
		"spring.datasource.driver-class-name=org.testcontainers.jdbc.ContainerDatabaseDriver",
		"spring.datasource.url=jdbc:tc:mysql:8:///"
	})
@AutoConfigureMockMvc
public class MainControllerWithTestContainerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void test() throws Exception {
		mockMvc.perform(get("/demo/all"))
				.andExpect(status().is2xxSuccessful());

		mockMvc.perform(post("/demo/add")
				.param("name", "Mark")
				.param("email", "hello@example.com"))
				.andExpect(status().is2xxSuccessful());

		mockMvc.perform(get("/demo/all"))
				.andExpect(status().is2xxSuccessful())
				.andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].name", is("Mark")))
				.andExpect(jsonPath("$[0].email", is("hello@example.com")))
				.andReturn();
	}
}
