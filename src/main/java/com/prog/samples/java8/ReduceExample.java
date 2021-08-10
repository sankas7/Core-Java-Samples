package com.prog.samples.java8;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReduceExample {

	public static void main(String args[]) {

	double avgSal=	getEmpDetails().stream().filter(emp -> emp.getGrade().equalsIgnoreCase("A")).mapToDouble(emp -> emp.getSalary())
		.average().getAsDouble();
	
	System.out.println("Avg Salary " +avgSal);
		
	}

	static List<EmployeeDetails> getEmpDetails() {
		return Stream.of(new EmployeeDetails("Rama", 50000, "A"), new EmployeeDetails("Shyama", 50000, "A"),
				new EmployeeDetails("Anil", 70000, "A"),new EmployeeDetails("Vinod", 50000, "B"))
				.collect(Collectors.toList());
	}

}

class EmployeeDetails {
	private String name;
	private Integer salary;
	private String grade;

	public EmployeeDetails(String name, Integer salary, String grade) {
		this.name = name;
		this.salary = salary;
		this.grade = grade;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

}