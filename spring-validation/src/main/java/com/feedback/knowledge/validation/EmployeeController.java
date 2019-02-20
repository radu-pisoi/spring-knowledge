package com.feedback.knowledge.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.knowledge.validation.dto.Employee;

@RestController
public class EmployeeController 
// implements WebMvcConfigurer 
{
	private static List<Employee> employeeList = new ArrayList<>();

	  @PostMapping("/")
	  public String handlePostRequest(@Valid Employee employee, BindingResult bindingResult) {
		  System.out.println("Validate employee: " + employee + " -- " + employee.getClass());
		  System.out.println("BR: " + bindingResult);
	      if (bindingResult.hasErrors()) {
				throw new InputValidationException(
     					  "Validation failed for: " + employee, bindingResult);
	      }
//	    	  System.out.println("Has errors: " + bindingResult.getErrorCount());
//	    	  System.out.println("Errors: " + bindingResult.getAllErrors());
////	          return "employee-form";
////	    	  throw new ResponseStatusException(HttpStatus., reason)
//	      } else {
//	    	  System.out.println("No errors");
//	      }
	      
	      employeeList.add(employee);
	      return "ok";
	  }
	  
	  @GetMapping("/")
	  public String handleGetRequest(Employee employee) {
	      return "employee-form";
	  }

	  @GetMapping("/employees")
	  public String handleGetRequest(Model model) {
	      model.addAttribute("employees", employeeList);
	      return "employee-view";
	  }
	  
//		@Override
//		public void addViewControllers(ViewControllerRegistry registry) {
//			// Admin pages
//	    	registry.addViewController("/").setViewName("employee-form");
//	        registry.addViewController("/employees").setViewName("employee-view");
//	    }
	    
}
