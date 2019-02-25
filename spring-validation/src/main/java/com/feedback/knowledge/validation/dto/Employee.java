package com.feedback.knowledge.validation.dto;

import java.time.LocalDate;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {
	
	public Employee(
			String name,
			String dept, 
			String dateOfBirth,
			String dateOfMarriage) {
		this.name = name;
		this.dept = dept;
		this.dateOfBirth = dateOfBirth;
		this.dateOfMarriage = dateOfMarriage;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	@NotNull
	@Size(min = 5, max = 50)
	private String name;
	
	@Pattern(regexp = "Admin|IT|Sales|Accounts")
	private String dept;
	
//	@Past
	@NotNull
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String dateOfBirth;
	
//	@Past
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String dateOfMarriage;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getDateOfMarriage() {
		return dateOfMarriage;
	}

	public void setDateOfMarriage(String dateOfMarriage) {
		this.dateOfMarriage = dateOfMarriage;
	}

	

//	@AssertTrue(message="The date of marriage should be greater than date of birth.")
//	private boolean isDateOfMarriageValid() {
//		boolean isValid = true;
//		if (dateOfMarriage != null && dateOfBirth != null) {
//			isValid = dateOfMarriage.isAfter(dateOfBirth);
//		}
//		return isValid;
//	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", dateOfBirth=" + dateOfBirth + "]";
	}
}
