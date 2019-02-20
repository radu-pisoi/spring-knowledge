package com.feedback.knowledge;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.feedback.knowledge.validation.EmployeeController;
import com.feedback.knowledge.validation.SpringValidationApplication;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
@ContextConfiguration(classes = {SpringValidationApplication.class})
public class EmployeeValidatorTest {
	/**
	 * Object for testing the MVC controller (ProductController).
	 */
	@Autowired
    private MockMvc mvc;
	
	@Test
	public void testEmployeeValidator() throws Exception {
		 //here no request body is added. Therefore the backend server should throw the BadRequest Exception
		ResultActions resultActions = 
				mvc.perform(post("/").content("{}").contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().is(HttpStatus.UNPROCESSABLE_ENTITY.value()));
		resultActions.andExpect(jsonPath("$.fieldErrorsMap.name", is("must not be null")));
		System.out.println("content is: '" + content() + "'");
	}
}
