package com.prog.samples.designpatterns;

public class BuilderPatternPerson {

	
	public static void main(String args[])
	{
		
		
		Person person = new Person.PersonBuilder("Pramit", "Brussels", "Brussels").isEmployed(true).isFemale(false)
				        .streetAddress("Rue Sainte Catherine").lastName("Bhaumik").createPerson();
		
		System.out.println("Person Name " + person.getFirstName() + " " + person.getLastName());
		
	}
}
