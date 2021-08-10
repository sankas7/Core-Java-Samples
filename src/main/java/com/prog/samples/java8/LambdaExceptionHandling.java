package com.prog.samples.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaExceptionHandling {

	public static void main(String args[]) {

		List<Integer> listObj = Arrays.asList(100, 200);

		List<String> listObj1 = Arrays.asList("100", "200", "xyz");
		
		
		listObj.stream().forEach(handleException(s -> {
			Thread.sleep(s);
			System.out.println("Slept for " + s + " ms");
		}));
		
		listObj1.stream().forEach(handleGenericException(s -> System.out.println(Integer.parseInt(s)), NumberFormatException.class));

	}

	static <T, E extends Exception> Consumer<T> handleGenericException(Consumer<T> targetConsumer,
			Class<E> exObjClass) {
		return obj -> {
			try {
				targetConsumer.accept(obj);
			} catch (Exception ex) {
				try {
					E exObj = exObjClass.cast(ex);
					System.out.println("exception : " + exObj.getMessage());
				} catch (ClassCastException ecx) {
					throw ex;
				}
			}
		};
	}

	static <T> Consumer<T> handleException(ExceptionHandlingInterface<T, Exception> handlerConsumer) {
		return obj -> {
			try {
				handlerConsumer.accept(obj);
			} catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}
}
