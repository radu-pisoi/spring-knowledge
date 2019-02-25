package com.feedback.knowledge;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feedback.knowledge.validation.EmployeeController;
import com.feedback.knowledge.validation.MyWebConfig;
import com.feedback.knowledge.validation.SpringValidationApplication;
import com.feedback.knowledge.validation.dto.Employee;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
@ContextConfiguration(classes = {SpringValidationApplication.class, MyWebConfig.class})
public class EmployeeValidatorTest {
	/**
	 * Object for testing the MVC controller (ProductController).
	 */
	@Autowired
    private MockMvc mvc;
	
	 @Autowired
	 private ObjectMapper objectMapper;
	
	@Test
	public void testEmployeeValidator() throws Exception {
		 //here no request body is added. Therefore the backend server should throw the BadRequest Exception
//		@NotNull
//		@Size(min = 5, max = 50)
//		private String name;
//		
//		@Pattern(regexp = "Admin|IT|Sales|Accounts")
//		private String dept;
//		
//		@Past
//		@NotNull
//		@DateTimeFormat(pattern = "yyyy-MM-dd")
//		private LocalDate dateOfBirth;
		String json = objectMapper.writeValueAsString(new Employee("userName", "ITT", "2011-01-05", null));
		System.out.println("Send json: " + json);
		ResultActions resultActions = 
				mvc
				.perform(post("/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().is(HttpStatus.UNPROCESSABLE_ENTITY.value()));
		resultActions.andExpect(jsonPath("$.fieldErrorsMap.name", is("must not be null")));
		System.out.println("content is: '" + content() + "'");
	}
}
