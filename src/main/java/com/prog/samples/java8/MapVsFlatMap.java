package com.prog.samples.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapVsFlatMap {

	public static void main(String args[]) {

		List<EmpData> list=Stream.of(new EmpData("Ram", "ram@gmail.com", Arrays.asList("9903185077", "22533222")),
				new EmpData("Shyam", "shyama@gmail.com", Arrays.asList("2552222", "112222")))
				.collect(Collectors.toList());
		
		//transform
		list.stream().map(emp -> emp.getEmailAddress()).forEach(System.out::println);
		
		//transform and flatten
		list.stream().flatMap(emp -> emp.getPhoneNumbers().stream()).forEach(System.out::println);
	}
}

class EmpData {
	private String name;
	private String emailAddress;
	private List<String> phoneNumbers;

	public EmpData(String name, String emailAddress, List<String> phoneNumbers) {
		super();
		this.name = name;
		this.emailAddress = emailAddress;
		this.phoneNumbers = phoneNumbers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

}
