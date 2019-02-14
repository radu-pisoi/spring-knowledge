package com.feedback.knowledge.validation.dto;

import java.time.LocalDate;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public LocalDate getDateOfMarriage() {
		return dateOfMarriage;
	}

	public void setDateOfMarriage(LocalDate dateOfMarriage) {
		this.dateOfMarriage = dateOfMarriage;
	}

	@NotNull
	@Size(min = 5, max = 50)
	private String name;
	
	@Pattern(regexp = "Admin|IT|Sales|Accounts")
	private String dept;
	
	@Past
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
	
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfMarriage;

	@AssertTrue(message="The date of marriage should be greater than date of birth.")
	private boolean isDateOfMarriageValid() {
		boolean isValid = true;
		if (dateOfMarriage != null && dateOfBirth != null) {
			isValid = dateOfMarriage.isAfter(dateOfBirth);
		}
		return isValid;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", dateOfBirth=" + dateOfBirth + "]";
	}
}
