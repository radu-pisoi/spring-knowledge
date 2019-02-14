package com.feedback.knowledge;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.feedback.knowledge.validation.EmployeeController;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
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
		System.out.println("result: " + resultActions);
	}
}
