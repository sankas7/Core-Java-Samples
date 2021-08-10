package com.prog.samples.java8;

@FunctionalInterface
public interface ExceptionHandlingInterface <T,E extends Exception> {

	
	public  void accept(T obj) throws E;
	
	
}
