package com.feedback.knowledge.validation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.feedback.knowledge.validation.dto.Employee;

@Controller
public class EmployeeController implements WebMvcConfigurer {
	private static List<Employee> employeeList = new ArrayList<>();
	
	@Autowired
	private Validator validator;
	
	@PostMapping("/")
	public String handlePostRequest(@RequestBody Employee employee) {
		System.out.println("Validate employee: " + employee + " -- " + employee.getClass());
		System.out.println("validator: " + validator);
		Set<ConstraintViolation<Employee>> validateRes = validator.validate(employee);
		System.out.println("validator res: " + validateRes);
		
		for (Iterator iterator = validateRes.iterator(); iterator.hasNext();) {
			ConstraintViolation<Employee> constraintViolation = (ConstraintViolation<Employee>) iterator.next();
			System.out.println("executable Parameters res: " + constraintViolation.getExecutableParameters());
			System.out.println("ConstraintDescriptor: " + constraintViolation.getConstraintDescriptor());
			System.out.println("ConstraintDescriptor: " + constraintViolation.getInvalidValue());
			
		}
//		if (bindingResult.hasErrors()) {
//			throw new InputValidationException("Validation failed for: " + employee, bindingResult);
//		}
//	    	  System.out.println("Has errors: " + bindingResult.getErrorCount());
//	    	  System.out.println("Errors: " + bindingResult.getAllErrors());
////	          return "employee-form";
////	    	  throw new ResponseStatusException(HttpStatus., reason)
//	      } else {
//	    	  System.out.println("No errors");
//	      }

		employeeList.add(employee);
		return "employee-view";
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

	@InitBinder
    public void initBinder(WebDataBinder binder) {
		binder.setBindingErrorProcessor(new CustomBindingErrorProcessor());
	}
}
