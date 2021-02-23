package com.prog.samples.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceLambda {

	
	public static void main(String args[])
	{
	
		List<Integer> listInt=Arrays.asList(23,55,455,67,52);
		
		Optional<Integer> opData=listInt.stream().map(i -> i*2).filter(i -> i%5==0).reduce(Math::max);
		
		if(opData.isPresent())
			System.out.println(opData.get());
		
	    //Optional<Integer> opt=	Optional.of(getInt());
		Optional<Integer> opt=	Optional.ofNullable(getInt());
		
		

	    //System.out.println(opt.get());
		System.out.println(opt.orElse(4));
		
		
		Optional<Company> companyOptional = Optional.empty();
		
	  
		companyOptional.filter(comp -> "Finance".equals(comp.getName())).ifPresent(comp -> System.out.println("Finamce is present"));
		
	}
	
	
	class Company
	{
		public String department;
		public String name;
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		
	}
	
	
	static Integer getInt()
	{
		return null;
	}

	
}
