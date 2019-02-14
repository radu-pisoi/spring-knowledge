package com.feedback.knowledge.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.feedback.knowledge.validation.dto.Employee;

@Controller
public class EmployeeController implements WebMvcConfigurer {
	private static List<Employee> employeeList = new ArrayList<>();

	  @PostMapping("/")
	  public String handlePostRequest(@Valid Employee employee, BindingResult bindingResult) {
		  System.out.println("Validate employee: " + employee + " -- " + employee.getClass());
	      if (bindingResult.hasErrors()) {
	    	  System.out.println("Has errors: " + bindingResult.getErrorCount());
	    	  System.out.println("Errors: " + bindingResult.getAllErrors());
	          return "employee-form";
	      } else {
	    	  System.out.println("No errors");
	      }
	      
	      employeeList.add(employee);
	      return "redirect:/employees";
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
	  
		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			// Admin pages
	    	registry.addViewController("/").setViewName("employee-form");
	        registry.addViewController("/employees").setViewName("employee-view");
	    }
	    
}
